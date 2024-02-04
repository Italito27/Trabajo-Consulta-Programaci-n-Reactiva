import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.stream.{ActorMaterializer, Materializer}

object EjemploConsulta extends App {
  // Crear un ActorSystem y un Materializer
  implicit val system: ActorSystem = ActorSystem("EjemploProgramaReactivo")
  implicit val materializer: Materializer = ActorMaterializer()

  // Operador de Transformación: mapConcat
  val sourceMapConcat = Source(1 to 5).mapConcat(x => List.fill(x)(x))

  // Operador de Filtrado: takeWhile
  val sourceTakeWhile = Source(1 to 10).takeWhile(_ < 6)

  // Operador de Combinación: zipWith
  val sourceZipWith = Source(1 to 3).zipWith(Source(4 to 6))((a, b) => s"$a-$b")

  // Ejecutar y mostrar resultados
  sourceMapConcat.runForeach(result => println(s"mapConcat: $result"))
  sourceTakeWhile.runForeach(result => println(s"takeWhile: $result"))
  sourceZipWith.runForeach(result => println(s"zipWith: $result"))

  system.terminate()
}
