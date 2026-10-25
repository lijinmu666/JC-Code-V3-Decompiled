package org.bouncycastle.p194crypto.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.generators.DESedeKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class DESExample {

    /* renamed from: cipher */
    private PaddedBufferedBlockCipher f20180cipher;

    /* renamed from: encrypt */
    private boolean f20181encrypt;

    /* renamed from: in */
    private BufferedInputStream f20182in;

    /* renamed from: key */
    private byte[] f20183key;

    /* renamed from: out */
    private BufferedOutputStream f20184out;

    public DESExample() {
        this.f20181encrypt = true;
        this.f20180cipher = null;
        this.f20182in = null;
        this.f20184out = null;
        this.f20183key = null;
    }

    /* renamed from: main */
    public static void m15464main(String[] strArr) throws IOException {
        String str;
        boolean z = true;
        if (strArr.length < 2) {
            new DESExample();
            System.err.println("Usage: java " + DESExample.class.getName() + " infile outfile [keyfile]");
            System.exit(1);
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        if (strArr.length > 2) {
            str = strArr[2];
            z = false;
        } else {
            str = "deskey.dat";
        }
        new DESExample(str2, str3, str, z).m15465process();
    }

    private void performDecrypt(byte[] bArr) throws IOException {
        this.f20180cipher.mo14952init(false, new KeyParameter(bArr));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f20182in));
        byte[] bArr2 = null;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
                byte[] bArrM18338decode = C6255Hex.m18338decode(line);
                bArr2 = new byte[this.f20180cipher.getOutputSize(bArrM18338decode.length)];
                int iProcessBytes = this.f20180cipher.processBytes(bArrM18338decode, 0, bArrM18338decode.length, bArr2, 0);
                if (iProcessBytes > 0) {
                    this.f20184out.write(bArr2, 0, iProcessBytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        int iMo14951doFinal = this.f20180cipher.mo14951doFinal(bArr2, 0);
        if (iMo14951doFinal > 0) {
            this.f20184out.write(bArr2, 0, iMo14951doFinal);
        }
    }

    private void performEncrypt(byte[] bArr) throws IOException {
        this.f20180cipher.mo14952init(true, new KeyParameter(bArr));
        byte[] bArr2 = new byte[47];
        byte[] bArr3 = new byte[this.f20180cipher.getOutputSize(47)];
        while (true) {
            try {
                int i = this.f20182in.read(bArr2, 0, 47);
                if (i <= 0) {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
                int iProcessBytes = this.f20180cipher.processBytes(bArr2, 0, i, bArr3, 0);
                if (iProcessBytes > 0) {
                    byte[] bArrM18344encode = C6255Hex.m18344encode(bArr3, 0, iProcessBytes);
                    this.f20184out.write(bArrM18344encode, 0, bArrM18344encode.length);
                    this.f20184out.write(10);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        int iMo14951doFinal = this.f20180cipher.mo14951doFinal(bArr3, 0);
        if (iMo14951doFinal > 0) {
            byte[] bArrM18344encode2 = C6255Hex.m18344encode(bArr3, 0, iMo14951doFinal);
            this.f20184out.write(bArrM18344encode2, 0, bArrM18344encode2.length);
            this.f20184out.write(10);
        }
    }

    /* renamed from: process */
    private void m15465process() throws IOException {
        this.f20180cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()));
        if (this.f20181encrypt) {
            performEncrypt(this.f20183key);
        } else {
            performDecrypt(this.f20183key);
        }
        try {
            this.f20182in.close();
            this.f20184out.flush();
            this.f20184out.close();
        } catch (IOException e) {
            System.err.println("exception closing resources: " + e.getMessage());
        }
    }

    public DESExample(String str, String str2, String str3, boolean z) throws IOException {
        SecureRandom secureRandom;
        PrintStream printStream;
        StringBuilder sb;
        String str4;
        SecureRandom secureRandom2 = null;
        this.f20180cipher = null;
        this.f20182in = null;
        this.f20184out = null;
        this.f20183key = null;
        this.f20181encrypt = z;
        try {
            this.f20182in = new BufferedInputStream(new FileInputStream(str));
        } catch (FileNotFoundException unused) {
            System.err.println("Input file not found [" + str + "]");
            System.exit(1);
        }
        try {
            this.f20184out = new BufferedOutputStream(new FileOutputStream(str2));
        } catch (IOException unused2) {
            System.err.println("Output file not created [" + str2 + "]");
            System.exit(1);
        }
        if (z) {
            try {
                secureRandom = new SecureRandom();
            } catch (Exception unused3) {
            }
            try {
                secureRandom.setSeed("www.bouncycastle.org".getBytes());
            } catch (Exception unused4) {
                secureRandom2 = secureRandom;
                try {
                    System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");
                    System.exit(1);
                    secureRandom = secureRandom2;
                    KeyGenerationParameters keyGenerationParameters = new KeyGenerationParameters(secureRandom, 192);
                    DESedeKeyGenerator dESedeKeyGenerator = new DESedeKeyGenerator();
                    dESedeKeyGenerator.mo14956init(keyGenerationParameters);
                    this.f20183key = dESedeKeyGenerator.generateKey();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                    byte[] bArrM18343encode = C6255Hex.m18343encode(this.f20183key);
                    bufferedOutputStream.write(bArrM18343encode, 0, bArrM18343encode.length);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return;
                } catch (IOException unused5) {
                    printStream = System.err;
                    sb = new StringBuilder();
                    str4 = "Could not decryption create key file [";
                }
            }
            KeyGenerationParameters keyGenerationParameters2 = new KeyGenerationParameters(secureRandom, 192);
            DESedeKeyGenerator dESedeKeyGenerator2 = new DESedeKeyGenerator();
            dESedeKeyGenerator2.mo14956init(keyGenerationParameters2);
            this.f20183key = dESedeKeyGenerator2.generateKey();
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str3));
            byte[] bArrM18343encode2 = C6255Hex.m18343encode(this.f20183key);
            bufferedOutputStream2.write(bArrM18343encode2, 0, bArrM18343encode2.length);
            bufferedOutputStream2.flush();
            bufferedOutputStream2.close();
            return;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str3));
            int iAvailable = bufferedInputStream.available();
            byte[] bArr = new byte[iAvailable];
            bufferedInputStream.read(bArr, 0, iAvailable);
            this.f20183key = C6255Hex.m18339decode(bArr);
            return;
        } catch (IOException unused6) {
            printStream = System.err;
            sb = new StringBuilder();
            str4 = "Decryption key file not found, or not valid [";
        }
        sb.append(str4);
        sb.append(str3);
        sb.append("]");
        printStream.println(sb.toString());
        System.exit(1);
    }
}
