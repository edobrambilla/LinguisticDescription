/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.lexicon

import com.beust.klaxon.*
import com.kotlinnlp.linguisticdescription.utils.forEachLine
import com.kotlinnlp.linguisticdescription.utils.toInputStream

/**
 * A lexicon dictionary.
 */
class LexiconDictionary {

  /**
   * An lexical entry of a dictionary entry, associated to a POS tag.
   *
   * @property sentiment the sentiment info of the entry
   * @property semantic the semantic info of the entry (can be null)
   */
  data class LexicalEntry(val sentiment: SentimentInfo, val semantic: SemanticInfo?)

  /**
   * Sentiment info.
   *
   * @property polarity the polarity (a value in the range [-1.0, 1.0])
   * @property categories a list of sentiment categories (can be null)
   */
  data class SentimentInfo(val polarity: Double, val categories: List<String>?)

  /**
   * Semantic info.
   *
   * @property analogy a list of terms that are semantically analogous (can be null)
   * @property classes a list of semantic classes (can be null)
   */
  data class SemanticInfo(val analogy: List<String>?, val classes: List<SemanticClass>?) {

    /**
     * Check requirements.
     */
    init {
      require(this.analogy != null || this.classes != null) {
        "At least one between the analogy and the classes must be not null."
      }
    }
  }

  /**
   * A semantic class.
   *
   * @property type the class type
   * @property name the class name
   */
  data class SemanticClass(val type: String, val name: String)

  companion object {

    /**
     * Load a [LexiconDictionary] from a JSONL file.
     *
     * @param filename the JSONL file name
     *
     * @return a new lexicon dictionary
     */
    fun load(filename: String): LexiconDictionary {

      val dictionary = LexiconDictionary()
      val jsonParser = Parser()

      forEachLine(filename) { line ->

        val entryObj: JsonObject = jsonParser.parse(line.toInputStream()) as JsonObject
        val lemma: String = entryObj.string("lemma")!!
        val lexicon: Map<String, Any?> = entryObj.obj("lexicon")!!.toMap()

        dictionary.lexiconMap[lemma] = lexicon.entries.associate {
          Pair(it.key, this.buildLexicalEntry(it.value as JsonObject))
        }
      }

      return dictionary
    }

    /**
     * @param jsonObject the JSON object that represents a lexical entry
     *
     * @return a lexical entry
     */
    private fun buildLexicalEntry(jsonObject: JsonObject): LexicalEntry {

      val sentiment: JsonObject = jsonObject.obj("sentiment")!!
      val semantic: JsonObject = jsonObject.obj("semantic")!!
      val semanticClasses = semantic.array<JsonArray<String>>("classes")
      val semanticAnalogy = semantic.array<String>("analogy")

      return LexicalEntry(
        sentiment = SentimentInfo(
          polarity = sentiment.double("polarity")!!,
          categories = sentiment.array("categories")),
        semantic = if (semanticClasses != null || semanticAnalogy != null)
          SemanticInfo(
            classes = semanticClasses?.map { SemanticClass(type = it[0], name = it[1]) },
            analogy = semanticAnalogy?.toList())
        else
          null
      )
    }
  }

  /**
   * Lexical entries associated by POS tags, in turn associated by lemma.
   */
  private val lexiconMap: MutableMap<String, Map<String, LexicalEntry>> = mutableMapOf()

  /**
   * Get a lexical entry by lemma and POS tag.
   *
   * @param lemma a lemma
   * @param posTag a POS tag annotation
   *
   * @return the lexical entry associated to the given [lemma] and [posTag] or null if no one has been found
   */
  fun get(lemma: String, posTag: String): LexicalEntry? = this.lexiconMap[lemma]?.get(posTag)
}