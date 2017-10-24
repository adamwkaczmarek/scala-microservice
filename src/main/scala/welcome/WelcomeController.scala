package welcome

import scala.concurrent.ExecutionContext

class WelcomeController(implicit ex:ExecutionContext) {

  def handleRequest(userName:String) :Welcome={

    Welcome(userName,"Hello 1")
  }

}
