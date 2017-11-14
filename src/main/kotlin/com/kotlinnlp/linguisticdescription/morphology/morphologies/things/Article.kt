/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.morphology.morphologies.things

import com.kotlinnlp.linguisticdescription.morphology.MorphologyType

/**
 * The 'article' morphology.
 */
sealed class Article : Thing {

  /**
   * The 'article' morphology.
   */
  class Base : Article() {

    override val type: MorphologyType = MorphologyType.Art
  }

  /**
   * The 'definite article' morphology.
   */
  class Definite : Article() {

    override val type: MorphologyType = MorphologyType.ArtDef
  }

  /**
   * The 'indefinite article' morphology.
   */
  sealed class Indefinite : Article() {

    /**
     * The 'indefinite article' morphology.
     */
    class Base : Article.Indefinite() {

      override val type: MorphologyType = MorphologyType.ArtIndef
    }

    /**
     * The 'indefinite partitive article' morphology.
     */
    class Partitive : Article.Indefinite() {

      override val type: MorphologyType = MorphologyType.ArtIndefPart
    }
  }
}
