import test._
import org.specs2.mutable.Specification
import com.sksamuel.avro4s._
import com.sksamuel.avro4s.ToSchema._

class StandardPrimitivesSpec extends Specification {

  "A case class with an `Int` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest00(1)
      val record2 = AvroTypeProviderTest00(2)
      val format = RecordFormat[AvroTypeProviderTest00]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Float` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest01(1F)
      val record2 = AvroTypeProviderTest01(2F)
      val format = RecordFormat[AvroTypeProviderTest01]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Long` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest02(1L)
      val record2 = AvroTypeProviderTest02(2L)
      val format = RecordFormat[AvroTypeProviderTest02]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Double` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest03(1D)
      val record2 = AvroTypeProviderTest03(2D)
      val format = RecordFormat[AvroTypeProviderTest03]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `Boolean` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest04(true)
      val record2 = AvroTypeProviderTest04(false)
      val format = RecordFormat[AvroTypeProviderTest04]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with an `String` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest05("hello world")
      val record2 = AvroTypeProviderTest05("hello galaxy")
      val format = RecordFormat[AvroTypeProviderTest05]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with a `BigDecimal` field from .avdl" should {
    "deserialize correctly" in {
      val record1 = DecimalIdl(BigDecimal(10.0))
      val record2 = DecimalIdl(BigDecimal(10.0))
      val format = RecordFormat[DecimalIdl]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with a `BigDecimal` field and default values from .avdl" should {
    "deserialize correctly" in {
      val record1 = DecimalIdl()
      val record2 = DecimalIdl()
      val format = RecordFormat[DecimalIdl]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with a `BigDecimal` field from .avsc" should {
    "deserialize correctly" in {
      val record1 = DecimalSc(BigDecimal(10.0))
      val record2 = DecimalSc(BigDecimal(10.0))
      val format = RecordFormat[DecimalSc]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

  "A case class with a union / optional BigDecimal contained within a Record from .avdl" should {
    "deserialize correctly" in {
      val record1 = UnionWithRecordOverBigDecimal(Some(DecimalIdl(BigDecimal(10.0))))
      val record2 = UnionWithRecordOverBigDecimal(Some(DecimalIdl(BigDecimal(10.0))))
      val format = RecordFormat[UnionWithRecordOverBigDecimal]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }



/*
  Avro4s is used to convert to `GenericRecord` for testing, chokes on `null`
  "A case class with an `Null` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest06(null)
      val record2 = AvroTypeProviderTest06(null)
      val format = RecordFormat[AvroTypeProviderTest06]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }
*/
  "A case class with an `Array[Bytes]` field" should {
    "deserialize correctly" in {
      val record1 = AvroTypeProviderTest69("hello world".getBytes)
      val record2 = AvroTypeProviderTest69("hello galaxy".getBytes)
      val format = RecordFormat[AvroTypeProviderTest69]
      val records = List(format.to(record1), format.to(record2))
      StandardTestUtil.verifyWriteAndRead(records)
    }
  }

}
