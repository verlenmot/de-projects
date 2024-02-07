package forecast.ingestion

import com.databricks.dbutils_v1.DBUtilsHolder.dbutils

object ApiRequest {

  def apiConnection(location: String): Map[String, Any] = {
    val apiKey: String = dbutils.secrets.get(scope = "scope-weather", key = "api")

    val paramMapForecast: Map[String, String] = Map(
      "location" -> location,
      "apikey" -> apiKey,
      "units" -> "metric",
      "timesteps" -> "1d,1h"
    )

    val r: requests.Response = requests.get("https://api.tomorrow.io/v4/weather/forecast", params = paramMapForecast)

    val text: String = r.text()
    val statusCode: Int = r.statusCode
    val statusMessage: String = r.statusMessage
    val headers: Map[String, Seq[String]] = r.headers

    val apiOutput: Map[String, Any] = Map(
      "statusCode" -> statusCode,
      "statusMessage" -> statusMessage,
      "data" -> text,
      "requestDatetime" -> headers("date")
    )
    apiOutput
  }
}
