package org.bouncycastle.p246its;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.OERInputStream;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataEncrypted;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.EncryptedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.RecipientInfo;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class ETSIEncryptedData {

    /* renamed from: oerDef */
    private static final C5887Element f21284oerDef = EtsiTs103097Module.EtsiTs103097Data_Encrypted.m17146build();
    private final EncryptedData encryptedData;

    public ETSIEncryptedData(InputStream inputStream) {
        Ieee1609Dot2Content content = EtsiTs103097DataEncrypted.getInstance((Object) (inputStream instanceof OERInputStream ? (OERInputStream) inputStream : new OERInputStream(inputStream)).m17161parse(f21284oerDef)).getContent();
        if (content.getChoice() != 2) {
            throw new IllegalStateException("EtsiTs103097Data-Encrypted did not have encrypted data content");
        }
        this.encryptedData = EncryptedData.getInstance(content.getIeee1609Dot2Content());
    }

    public byte[] getEncoded() {
        return OEREncoder.toByteArray(new EtsiTs103097DataEncrypted(Ieee1609Dot2Content.encryptedData(this.encryptedData)), f21284oerDef);
    }

    public EncryptedData getEncryptedData() {
        return this.encryptedData;
    }

    public InterfaceC6249Store<ETSIRecipientInfo> getRecipients() {
        ArrayList arrayList = new ArrayList();
        Iterator<RecipientInfo> it = this.encryptedData.getRecipients().getRecipientInfos().iterator();
        while (it.hasNext()) {
            arrayList.add(new ETSIRecipientInfo(this.encryptedData, it.next()));
        }
        return new CollectionStore(arrayList);
    }

    public ETSIEncryptedData(EncryptedData encryptedData) {
        this.encryptedData = encryptedData;
    }

    public ETSIEncryptedData(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
