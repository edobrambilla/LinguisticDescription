/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.sentence.token

import com.kotlinnlp.linguisticdescription.POSTag
import com.kotlinnlp.linguisticdescription.morphology.Morphology

/**
 * A token with a list of possible morphologies.
 */
interface MorphoToken : Token {

  /**
   * The list of possible morphologies of the token (can be empty).
   */
  val morphologies: List<Morphology>

  /**
   * The Part-Of-Speech (can be null).
   */
  val pos: POSTag?
}
