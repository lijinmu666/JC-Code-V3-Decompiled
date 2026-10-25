package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() { // from class: com.google.crypto.tink.shaded.protobuf.ManifestSchemaFactory.1
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    private final MessageInfoFactory messageInfoFactory;

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory());
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        try {
            return (MessageInfoFactory) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return EMPTY_FACTORY;
        }
    }

    private static boolean isProto2(MessageInfo messageInfo) {
        return messageInfo.getSyntax() == ProtoSyntax.PROTO2;
    }

    private static <T> InterfaceC0777Schema<T> newSchema(Class<T> cls, MessageInfo messageInfo) {
        return GeneratedMessageLite.class.isAssignableFrom(cls) ? isProto2(messageInfo) ? MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.m4107lite(), ListFieldSchema.m4069lite(), SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.m3987lite(), MapFieldSchemas.m4084lite()) : MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.m4107lite(), ListFieldSchema.m4069lite(), SchemaUtil.unknownFieldSetLiteSchema(), null, MapFieldSchemas.m4084lite()) : isProto2(messageInfo) ? MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.m4106full(), ListFieldSchema.m4068full(), SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.m3986full(), MapFieldSchemas.m4083full()) : MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.m4106full(), ListFieldSchema.m4068full(), SchemaUtil.proto3UnknownFieldSetSchema(), null, MapFieldSchemas.m4083full());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.SchemaFactory
    public <T> InterfaceC0777Schema<T> createSchema(Class<T> cls) {
        SchemaUtil.requireGeneratedMessage(cls);
        MessageInfo messageInfoMessageInfoFor = this.messageInfoFactory.messageInfoFor(cls);
        return messageInfoMessageInfoFor.isMessageSetWireFormat() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.m3987lite(), messageInfoMessageInfoFor.getDefaultInstance()) : MessageSetSchema.newSchema(SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.m3986full(), messageInfoMessageInfoFor.getDefaultInstance()) : newSchema(cls, messageInfoMessageInfoFor);
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(messageInfoFactory, "messageInfoFactory");
    }
}
