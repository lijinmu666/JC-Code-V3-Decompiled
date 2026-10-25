package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class LowmcConstantsL5 extends LowmcConstants {
    public LowmcConstantsL5() {
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(LowmcConstants.class.getResourceAsStream("lowmcL5.bin.properties")));
            this.linearMatrices = LowmcConstants.readArray(dataInputStream);
            this.roundConstants = LowmcConstants.readArray(dataInputStream);
            this.keyMatrices = LowmcConstants.readArray(dataInputStream);
            this.linearMatrices_full = LowmcConstants.readArray(dataInputStream);
            this.keyMatrices_full = LowmcConstants.readArray(dataInputStream);
            this.keyMatrices_inv = LowmcConstants.readArray(dataInputStream);
            this.linearMatrices_inv = LowmcConstants.readArray(dataInputStream);
            this.roundConstants_full = LowmcConstants.readArray(dataInputStream);
            this.f23967LMatrix = new KMatrices(38, 256, 8, this.linearMatrices);
            this.f23966KMatrix = new KMatrices(39, 256, 8, this.keyMatrices);
            this.RConstants = new KMatrices(38, 1, 8, this.roundConstants);
            this.LMatrix_full = new KMatrices(4, 255, 8, this.linearMatrices_full);
            this.LMatrix_inv = new KMatrices(4, 255, 8, this.linearMatrices_inv);
            this.KMatrix_full = new KMatrices(5, 255, 8, this.keyMatrices_full);
            this.KMatrix_inv = new KMatrices(1, 255, 8, this.keyMatrices_inv);
            this.RConstants_full = new KMatrices(4, 1, 8, this.roundConstants_full);
        } catch (IOException e) {
            throw Exceptions.illegalStateException("unable to load Picnic properties: " + e.getMessage(), e);
        }
    }
}
