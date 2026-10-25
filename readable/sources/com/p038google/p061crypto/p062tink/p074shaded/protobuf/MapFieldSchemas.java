package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
final class MapFieldSchemas {
    private static final MapFieldSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final MapFieldSchema LITE_SCHEMA = new MapFieldSchemaLite();

    /* renamed from: full */
    public static MapFieldSchema m4083full() {
        return FULL_SCHEMA;
    }

    /* renamed from: lite */
    public static MapFieldSchema m4084lite() {
        return LITE_SCHEMA;
    }

    private static MapFieldSchema loadSchemaForFullRuntime() {
        try {
            return (MapFieldSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
