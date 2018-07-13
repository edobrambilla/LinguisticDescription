/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.sentence.token

import com.kotlinnlp.linguisticdescription.morphology.LexicalInterpretation

/**
 * The LexicalToken.
 */
interface LexicalToken : Token {

  /**
   * The list of lexical interpretations, sorted by score in a descending order.
   */
  val lexicalInterpretations: List<LexicalInterpretation>
}
