/* Copyright 2017-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.linguisticdescription.morphology

import com.kotlinnlp.linguisticdescription.morphology.morphologies.Morphology
import com.kotlinnlp.linguisticdescription.morphology.morphologies.MorphologyFactory
import java.io.Serializable

/**
 * The encoded morphology of an entry of the [MorphologyDictionary].
 */
class EncodedMorphology(
  val lemma: String,
  val typeIndex: Int,
  val propertiesIndex: Int,
  private val compressor: MorphologyCompressor
) : Serializable {

  /**
   * @return the morphology decoded from this one
   */
  fun decode(): Morphology = MorphologyFactory(
    lemma = this.lemma,
    type = this.compressor.decodeType(this.typeIndex),
    properties = this.compressor.decodeProperties(this.propertiesIndex)
  )

  override fun hashCode(): Int = "%s\t%d\t%d".format(this.lemma, this.typeIndex, this.propertiesIndex).hashCode()

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as EncodedMorphology

    if (this.lemma != other.lemma) return false
    if (this.typeIndex != other.typeIndex) return false
    if (this.propertiesIndex != other.propertiesIndex) return false

    return true
  }
}
