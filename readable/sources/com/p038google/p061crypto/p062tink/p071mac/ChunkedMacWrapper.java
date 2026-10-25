package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChunkedMacWrapper implements PrimitiveWrapper<ChunkedMac, ChunkedMac> {

    /* renamed from: WRAPPER */
    private static final ChunkedMacWrapper f3152WRAPPER = new ChunkedMacWrapper();

    public static class WrappedChunkedMac implements ChunkedMac {
        private final PrimitiveSet<ChunkedMac> primitives;

        private ChunkedMac getChunkedMac(PrimitiveSet.C0320Entry<ChunkedMac> c0320Entry) {
            return c0320Entry.getFullPrimitive();
        }

        @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
        public ChunkedMacComputation createComputation() {
            return getChunkedMac(this.primitives.getPrimary()).createComputation();
        }

        @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
        public ChunkedMacVerification createVerification(byte[] bArr) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            ArrayList arrayList = new ArrayList();
            Iterator<PrimitiveSet.C0320Entry<ChunkedMac>> it = this.primitives.getPrimitive(bArrCopyOf).iterator();
            while (it.hasNext()) {
                arrayList.add(getChunkedMac(it.next()).createVerification(bArr));
            }
            Iterator<PrimitiveSet.C0320Entry<ChunkedMac>> it2 = this.primitives.getRawPrimitives().iterator();
            while (it2.hasNext()) {
                arrayList.add(getChunkedMac(it2.next()).createVerification(bArr));
            }
            return new WrappedChunkedMacVerification(arrayList);
        }

        private WrappedChunkedMac(PrimitiveSet<ChunkedMac> primitiveSet) {
            this.primitives = primitiveSet;
        }
    }

    public static class WrappedChunkedMacVerification implements ChunkedMacVerification {
        private final List<ChunkedMacVerification> verifications;

        @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
        /* renamed from: update */
        public void mo3519update(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.mark();
            for (ChunkedMacVerification chunkedMacVerification : this.verifications) {
                byteBufferDuplicate.reset();
                chunkedMacVerification.mo3519update(byteBufferDuplicate);
            }
            byteBuffer.position(byteBuffer.limit());
        }

        @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
        public void verifyMac() throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("MAC verification failed for all suitable keys in keyset");
            Iterator<ChunkedMacVerification> it = this.verifications.iterator();
            while (it.hasNext()) {
                try {
                    it.next().verifyMac();
                    return;
                } catch (GeneralSecurityException e) {
                    generalSecurityException.addSuppressed(e);
                }
            }
            throw generalSecurityException;
        }

        private WrappedChunkedMacVerification(List<ChunkedMacVerification> list) {
            this.verifications = list;
        }
    }

    private ChunkedMacWrapper() {
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3152WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<ChunkedMac> getInputPrimitiveClass() {
        return ChunkedMac.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<ChunkedMac> getPrimitiveClass() {
        return ChunkedMac.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public ChunkedMac mo3385wrap(PrimitiveSet<ChunkedMac> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (primitiveSet.getPrimary() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator<List<PrimitiveSet.C0320Entry<ChunkedMac>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            Iterator<PrimitiveSet.C0320Entry<ChunkedMac>> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().getFullPrimitive();
            }
        }
        return new WrappedChunkedMac(primitiveSet);
    }
}
