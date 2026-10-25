package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CheckReturnValue
/* loaded from: classes.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, InterfaceC0777Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int schemaSize = 0;
        for (InterfaceC0777Schema<?> interfaceC0777Schema : this.schemaCache.values()) {
            if (interfaceC0777Schema instanceof MessageSchema) {
                schemaSize += ((MessageSchema) interfaceC0777Schema).getSchemaSize();
            }
        }
        return schemaSize;
    }

    public <T> boolean isInitialized(T t) {
        return schemaFor((Protobuf) t).isInitialized(t);
    }

    public <T> void makeImmutable(T t) {
        schemaFor((Protobuf) t).makeImmutable(t);
    }

    public <T> void mergeFrom(T t, InterfaceC0775Reader interfaceC0775Reader) {
        mergeFrom(t, interfaceC0775Reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public InterfaceC0777Schema<?> registerSchema(Class<?> cls, InterfaceC0777Schema<?> interfaceC0777Schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(interfaceC0777Schema, "schema");
        return this.schemaCache.putIfAbsent(cls, interfaceC0777Schema);
    }

    @CanIgnoreReturnValue
    public InterfaceC0777Schema<?> registerSchemaOverride(Class<?> cls, InterfaceC0777Schema<?> interfaceC0777Schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(interfaceC0777Schema, "schema");
        return this.schemaCache.put(cls, interfaceC0777Schema);
    }

    public <T> InterfaceC0777Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        InterfaceC0777Schema<T> interfaceC0777Schema = (InterfaceC0777Schema) this.schemaCache.get(cls);
        if (interfaceC0777Schema != null) {
            return interfaceC0777Schema;
        }
        InterfaceC0777Schema<T> interfaceC0777SchemaCreateSchema = this.schemaFactory.createSchema(cls);
        InterfaceC0777Schema<T> interfaceC0777Schema2 = (InterfaceC0777Schema<T>) registerSchema(cls, interfaceC0777SchemaCreateSchema);
        return interfaceC0777Schema2 != null ? interfaceC0777Schema2 : interfaceC0777SchemaCreateSchema;
    }

    /* renamed from: writeTo */
    public <T> void m4119writeTo(T t, InterfaceC0811Writer interfaceC0811Writer) {
        schemaFor((Protobuf) t).mo4094writeTo(t, interfaceC0811Writer);
    }

    public <T> void mergeFrom(T t, InterfaceC0775Reader interfaceC0775Reader, ExtensionRegistryLite extensionRegistryLite) {
        schemaFor((Protobuf) t).mergeFrom(t, interfaceC0775Reader, extensionRegistryLite);
    }

    public <T> InterfaceC0777Schema<T> schemaFor(T t) {
        return schemaFor((Class) t.getClass());
    }
}
