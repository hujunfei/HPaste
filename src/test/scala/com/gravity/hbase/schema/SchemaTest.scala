package com.gravity.hbase.schema

import org.apache.hadoop.hbase.HBaseConfiguration
import org.junit.Test

/*             )\._.,--....,'``.
 .b--.        /;   _.. \   _\  (`._ ,.
`=,-,-'~~~   `----(,_..'--(,_..'`-.;.'  */

object ExampleSchema {
  implicit val conf = HBaseConfiguration.create

  object ExampleTable extends HbaseTable(tableName="schema_example") {

    val meta = family[String,String,Any]("meta")
    val title = column(meta,"title", classOf[String])
    val url = column(meta,"url", classOf[String])
  }

}

class SchemaTest  {

  @Test def createAndDelete() {
    val create = ExampleSchema.ExampleTable.createScript()
    println(create)
  }
}