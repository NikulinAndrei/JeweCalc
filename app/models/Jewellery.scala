package models

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 */
case class Jewellery (
  material: String,
  unit: String,
  pricePerUnit: Int,
  probe: Option[Int],
  weight: Option[Int]
)

