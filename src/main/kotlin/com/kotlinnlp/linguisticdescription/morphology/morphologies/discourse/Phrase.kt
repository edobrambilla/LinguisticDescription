/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.morphology.morphologies.discourse

import com.kotlinnlp.linguisticdescription.Discourse
import com.kotlinnlp.linguisticdescription.morphology.MorphologyType
import com.kotlinnlp.linguisticdescription.morphology.morphologies.Morphology

/**
 * The 'phrase' morphology.
 */
sealed class Phrase : Morphology(), Discourse {

  /**
   * The 'affirmative phrase' morphology.
   */
  class Affirmative : Phrase() {

    override val type: MorphologyType = MorphologyType.PhrasAff
  }

  /**
   * The 'exclamative phrase' morphology.
   */
  class Exclamative : Phrase() {

    override val type: MorphologyType = MorphologyType.PhrasExclam
  }

  /**
   * The 'interrogative phrase' morphology.
   */
  class Interrogative : Phrase() {

    override val type: MorphologyType = MorphologyType.PhrasInterr
  }

  /**
   * The 'negative phrase' morphology.
   */
  class Negative : Phrase() {

    override val type: MorphologyType = MorphologyType.PhrasNeg
  }
}
