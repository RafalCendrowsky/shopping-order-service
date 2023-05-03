package shopping.order

import org.slf4j.LoggerFactory
import shopping.order.proto.{OrderRequest, OrderResponse, ShoppingOrderService}

import scala.concurrent.Future

class ShoppingOrderServiceImpl extends ShoppingOrderService {

  private val log = LoggerFactory.getLogger(getClass)

  override def order(in: OrderRequest): Future[OrderResponse] = {
    val totalNumberOfItems = in.items.map(_.quantity).sum
    log.info(
      "Order for {} items  from cart {} received",
      totalNumberOfItems,
      in.cartId
    )
    Future.successful(OrderResponse(ok = true))
  }
}
