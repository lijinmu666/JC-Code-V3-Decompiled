package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

/* loaded from: classes.dex */
final class TextFormatEscaper {

    public interface ByteSequence {
        /* renamed from: byteAt */
        byte mo4133byteAt(int i);

        /* renamed from: size */
        int mo4134size();
    }

    private TextFormatEscaper() {
    }

    public static String escapeBytes(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.mo4134size());
        for (int i = 0; i < byteSequence.mo4134size(); i++) {
            byte bMo4133byteAt = byteSequence.mo4133byteAt(i);
            if (bMo4133byteAt == 34) {
                sb.append("\\\"");
            } else if (bMo4133byteAt == 39) {
                sb.append("\\'");
            } else if (bMo4133byteAt != 92) {
                switch (bMo4133byteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bMo4133byteAt < 32 || bMo4133byteAt > 126) {
                            sb.append('\\');
                            sb.append((char) (((bMo4133byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((bMo4133byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((bMo4133byteAt & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bMo4133byteAt);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    public static String escapeBytes(final ByteString byteString) {
        return escapeBytes(new ByteSequence() { // from class: com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.1
            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            /* renamed from: byteAt */
            public byte mo4133byteAt(int i) {
                return byteString.mo3937byteAt(i);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            /* renamed from: size */
            public int mo4134size() {
                return byteString.mo3944size();
            }
        });
    }

    public static String escapeBytes(final byte[] bArr) {
        return escapeBytes(new ByteSequence() { // from class: com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.2
            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            /* renamed from: byteAt */
            public byte mo4133byteAt(int i) {
                return bArr[i];
            }

            @Override // com.google.crypto.tink.shaded.protobuf.TextFormatEscaper.ByteSequence
            /* renamed from: size */
            public int mo4134size() {
                return bArr.length;
            }
        });
    }
}
