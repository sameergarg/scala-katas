package com.netaporter.shop

import scala.io.Source

trait ProductService {
  def listProducts: Iterator[Product]
}

trait FileBackedProductService extends ProductService {

  private[shop] val productItems: Iterator[String] = Source.fromInputStream(getClass.getResourceAsStream("/Items.csv"))
    .getLines()
    .drop(1)

  private[shop] val productAttributes: String => Array[String] = _.split(",")

  private[shop] val parseAmount: String => BigDecimal = price => BigDecimal(price.dropWhile(!_.isDigit))

  private[shop] val parseToProduct: String => Product = line => productAttributes(line) match {
    case Array(id, name, price) => Product(id.toLong, name, parseAmount(price))
  }

  def listProducts: Iterator[Product] = productItems.map(parseToProduct)
}

object Inventory extends FileBackedProductService {
  val allProducts = listProducts.toList
}

