/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.sentence.token

import com.kotlinnlp.linguisticdescription.morphology.ScoredMorphology

/**
 * A token with a list of possible scored morphologies.
 */
interface ScoredMorphoToken : Token {

  /**
   * The list of possible scored morphologies, sorted by descending score.
   */
  val morphologies: List<ScoredMorphology>
}