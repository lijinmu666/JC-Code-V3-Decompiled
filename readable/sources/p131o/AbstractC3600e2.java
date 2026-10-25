package p131o;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;

/* renamed from: o.e2 */
/* loaded from: classes.dex */
public abstract class AbstractC3600e2 {

    /* renamed from: o.e2$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public final long f13430AZxh;

        /* renamed from: mjFkc */
        public final long f13431mjFkc;

        public AZxh(long j, long j2) {
            this.f13431mjFkc = j;
            this.f13430AZxh = j2;
        }

        /* renamed from: mjFkc */
        public long m11796mjFkc() {
            return this.f13431mjFkc;
        }
    }

    /* renamed from: o.e2$mjFkc */
    public static class mjFkc implements wA {

        /* renamed from: mjFkc */
        public final ByteBuffer f13432mjFkc;

        public mjFkc(ByteBuffer byteBuffer) {
            this.f13432mjFkc = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // p131o.AbstractC3600e2.wA
        /* renamed from: AZxh */
        public long mo11797AZxh() {
            return AbstractC3600e2.m11795wA(this.f13432mjFkc.getInt());
        }

        @Override // p131o.AbstractC3600e2.wA
        public long getPosition() {
            return this.f13432mjFkc.position();
        }

        @Override // p131o.AbstractC3600e2.wA
        /* renamed from: mjFkc */
        public void mo11798mjFkc(int i) {
            ByteBuffer byteBuffer = this.f13432mjFkc;
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // p131o.AbstractC3600e2.wA
        public int readUnsignedShort() {
            return AbstractC3600e2.m11793ZfxDd(this.f13432mjFkc.getShort());
        }

        @Override // p131o.AbstractC3600e2.wA
        /* renamed from: wA */
        public int mo11799wA() {
            return this.f13432mjFkc.getInt();
        }
    }

    /* renamed from: o.e2$wA */
    public interface wA {
        /* renamed from: AZxh */
        long mo11797AZxh();

        long getPosition();

        /* renamed from: mjFkc */
        void mo11798mjFkc(int i);

        int readUnsignedShort();

        /* renamed from: wA */
        int mo11799wA();
    }

    /* renamed from: AZxh */
    public static C3536d2 m11792AZxh(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) m11794mjFkc(new mjFkc(byteBufferDuplicate)).m11796mjFkc());
        return C3536d2.m11641lgHUyS(byteBufferDuplicate);
    }

    /* renamed from: ZfxDd */
    public static int m11793ZfxDd(short s) {
        return s & 65535;
    }

    /* renamed from: mjFkc */
    public static AZxh m11794mjFkc(wA wAVar) throws IOException {
        long jMo11797AZxh;
        wAVar.mo11798mjFkc(4);
        int unsignedShort = wAVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        wAVar.mo11798mjFkc(6);
        int i = 0;
        while (true) {
            if (i >= unsignedShort) {
                jMo11797AZxh = -1;
                break;
            }
            int iMo11799wA = wAVar.mo11799wA();
            wAVar.mo11798mjFkc(4);
            jMo11797AZxh = wAVar.mo11797AZxh();
            wAVar.mo11798mjFkc(4);
            if (1835365473 == iMo11799wA) {
                break;
            }
            i++;
        }
        if (jMo11797AZxh != -1) {
            wAVar.mo11798mjFkc((int) (jMo11797AZxh - wAVar.getPosition()));
            wAVar.mo11798mjFkc(12);
            long jMo11797AZxh2 = wAVar.mo11797AZxh();
            for (int i2 = 0; i2 < jMo11797AZxh2; i2++) {
                int iMo11799wA2 = wAVar.mo11799wA();
                long jMo11797AZxh3 = wAVar.mo11797AZxh();
                long jMo11797AZxh4 = wAVar.mo11797AZxh();
                if (1164798569 == iMo11799wA2 || 1701669481 == iMo11799wA2) {
                    return new AZxh(jMo11797AZxh3 + jMo11797AZxh, jMo11797AZxh4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* renamed from: wA */
    public static long m11795wA(int i) {
        return i & BodyPartID.bodyIdMax;
    }
}
