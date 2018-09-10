/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.morphology.morphologies.relations

import com.kotlinnlp.linguisticdescription.morphology.POS
import com.kotlinnlp.linguisticdescription.morphology.morphologies.ContentWord
import com.kotlinnlp.linguisticdescription.morphology.SingleMorphology
import com.kotlinnlp.linguisticdescription.morphology.properties.*
import com.kotlinnlp.linguisticdescription.morphology.properties.interfaces.Gradable

/**
 * The 'adverb' morphology.
 *
 * @property lemma the lemma
 * @property degree the 'degree' morphology property
 */
sealed class Adverb(
  lemma: String,
  override val degree: Degree
) : SingleMorphology(lemma), Relation, Gradable {

  /**
   * The 'adversative adverb' morphology.
   */
  class Adversative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvAdvers
  }

  /**
   * The 'comparative adverb' morphology.
   */
  class Comparative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvCompar
  }

  /**
   * The 'concessive adverb' morphology.
   */
  class Concessive(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvConcess
  }

  /**
   * The 'deictic adverb' morphology.
   */
  class Deictic(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvDeict
  }

  /**
   * The 'indefinite adverb' morphology.
   */
  class Indefinite(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvIndef
  }

  /**
   * The 'indefinite subordinating adverb' morphology.
   */
  class IndefiniteSubordinating(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvIndefSubord
  }

  /**
   * The 'interrogative adverb' morphology.
   */
  class Interrogative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvInterr
  }

  /**
   * The 'limiting adverb' morphology.
   */
  class Limiting(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvLimit
  }

  /**
   * The 'locative adverb' morphology.
   */
  class Locative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvLoc
  }

  /**
   * The 'modal adverb' morphology.
   */
  class Modal(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree), ContentWord {

    override val pos: POS = POS.AdvModal
  }

  /**
   * The 'negative adverb' morphology.
   */
  class Negative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvNeg
  }

  /**
   * The 'adverbial phrase' morphology.
   */
  class Phrase(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvPhras
  }

  /**
   * The 'quantitative adverb' morphology.
   */
  class Quantitative(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvQuant
  }

  /**
   * The 'strength adverb' morphology.
   */
  sealed class Strength(lemma: String, degree: Degree) : Adverb(lemma, degree) {

    /**
     * The 'strength adverb' morphology.
     */
    class Base(lemma: String, degree: Degree = Degree.Base) : Adverb.Strength(lemma, degree) {

      override val pos: POS = POS.AdvStreng
    }

    /**
     * The 'negative strength adverb' morphology.
     */
    class Negative(lemma: String, degree: Degree = Degree.Base) : Adverb.Strength(lemma, degree) {

      override val pos: POS = POS.AdvStrengNeg
    }
  }

  /**
   * The 'time adverb' morphology.
   */
  class Time(lemma: String, degree: Degree = Degree.Base) : Adverb(lemma, degree) {

    override val pos: POS = POS.AdvTime
  }
}
