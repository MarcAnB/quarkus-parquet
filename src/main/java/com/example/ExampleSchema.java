package com.example;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;

public class ExampleSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("" +
            "{" +
            "\"type\":\"record\"," +
            "\"name\":\"ExampleSchema\"," +
            "\"namespace\":\"com.example\"," +
            "\"doc\":\"data structure to store stuff\"," +
            "\"fields\":[" +
            "{" +
            "\"name\":\"id\"," +
            "\"type\":\"int\"," +
            "\"doc\":\"monotonically increasing integer id; to be used as foreign key in the peptide file.\"" +
            "},{" +
            "\"name\":\"name\"," +
            "\"type\":\"string\"," +
            "\"doc\":\"protein group name or family name; where protein group only consists of single member, it would equal protein_ID\"" +
            "}" +
            "]," +
            "\"version\":\"1\"" +
            "}");
    private static final long serialVersionUID = -4519398270771510448L;
    private static final SpecificData MODEL$ = new SpecificData();
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<ExampleSchema>
            WRITER$ = (org.apache.avro.io.DatumWriter<ExampleSchema>) MODEL$.createDatumWriter(SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<ExampleSchema>
            READER$ = (org.apache.avro.io.DatumReader<ExampleSchema>) MODEL$.createDatumReader(SCHEMA$);
    /**
     * monotonically increasing integer id; to be used as foreign key in the peptide file.
     */
    private int id;
    /**
     * protein group name or family name; where protein group only consists of single member, it would equal protein_ID
     */
    private java.lang.CharSequence name;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public ExampleSchema() {
    }

    /**
     * All-args constructor.
     *
     * @param id   monotonically increasing integer id; to be used as foreign key in the peptide file.
     * @param name protein group name or family name; where protein group only consists of single member, it would equal protein_ID
     */
    public ExampleSchema(java.lang.Integer id, java.lang.CharSequence name) {
        this.id = id;
        this.name = name;
    }

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    @Override
    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    @Override
    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    @Override
    public java.lang.Object get(int field$) {
        return switch (field$) {
            case 0 -> id;
            case 1 -> name;
            default -> throw new IndexOutOfBoundsException("Invalid index: " + field$);
        };
    }

    // Used by DatumReader.  Applications should not call.
    @Override
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                id = (java.lang.Integer) value$;
                break;
            case 1:
                name = (java.lang.CharSequence) value$;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    @Override
    protected boolean hasCustomCoders() {
        return true;
    }

    @Override
    public void customEncode(org.apache.avro.io.Encoder out)
            throws java.io.IOException {
        out.writeInt(this.id);

        out.writeString(this.name);

    }

    @Override
    public void customDecode(org.apache.avro.io.ResolvingDecoder in)
            throws java.io.IOException {
        org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
        if (fieldOrder == null) {
            this.id = in.readInt();

            this.name = in.readString(this.name instanceof Utf8 ? (Utf8) this.name : null);

        } else {
            for (int i = 0; i < 2; i++) {
                switch (fieldOrder[i].pos()) {
                    case 0:
                        this.id = in.readInt();
                        break;

                    case 1:
                        this.name = in.readString(this.name instanceof Utf8 ? (Utf8) this.name : null);
                        break;

                    default:
                        throw new java.io.IOException("Corrupt ResolvingDecoder.");
                }
            }
        }
    }
}









