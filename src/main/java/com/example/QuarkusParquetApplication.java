package com.example;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.io.LocalOutputFile;

import java.io.IOException;
import java.nio.file.Path;

@QuarkusMain
@RegisterForReflection(targets = {
        org.apache.parquet.hadoop.codec.SnappyCodec.class,
        org.apache.parquet.avro.SpecificDataSupplier.class
})
public class QuarkusParquetApplication implements QuarkusApplication {

    @Override
    public int run(String... args) throws IOException {
        try (ParquetWriter<ExampleSchema> writer = AvroParquetWriter
                .<ExampleSchema>builder(new LocalOutputFile(Path.of("output.parquet")))
                .withRowGroupSize(256L * 1024L * 1024L)
                .withPageSize(128 * 1024)
                .withSchema(ExampleSchema.getClassSchema())
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .withValidation(false)
                .withDictionaryEncoding(false)
                .build()) {
            writer.write(new ExampleSchema(1, "random_group_1"));
            writer.write(new ExampleSchema(2, "random_group_2"));
            writer.write(new ExampleSchema(3, "random_group_3"));
            writer.write(new ExampleSchema(4, "random_group_4"));
        }

        return 0;
    }
}