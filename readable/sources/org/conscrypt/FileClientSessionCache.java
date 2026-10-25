package org.conscrypt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.conscrypt.p369io.C6343IoUtils;

/* loaded from: classes2.dex */
public final class FileClientSessionCache {
    public static final int MAX_SIZE = 12;

    /* renamed from: logger */
    private static final Logger f24369logger = Logger.getLogger(FileClientSessionCache.class.getName());

    /* renamed from: caches */
    static final Map<File, C6286Impl> f24368caches = new HashMap();

    public static class CacheFile extends File {
        long lastModified;

        /* renamed from: name */
        final String f24370name;

        public CacheFile(File file, String str) {
            super(file, str);
            this.lastModified = -1L;
            this.f24370name = str;
        }

        @Override // java.io.File
        public long lastModified() {
            long j = this.lastModified;
            if (j != -1) {
                return j;
            }
            long jLastModified = super.lastModified();
            this.lastModified = jLastModified;
            return jLastModified;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.Comparable
        public int compareTo(File file) {
            long jLastModified = lastModified() - file.lastModified();
            return jLastModified == 0 ? super.compareTo(file) : jLastModified < 0 ? -1 : 1;
        }
    }

    /* renamed from: org.conscrypt.FileClientSessionCache$Impl */
    public static class C6286Impl implements SSLClientSessionCache {
        Map<String, File> accessOrder = newAccessOrder();
        final File directory;
        String[] initialFiles;

        /* renamed from: size */
        int f24371size;

        public C6286Impl(File file) throws IOException {
            boolean zExists = file.exists();
            if (zExists && !file.isDirectory()) {
                throw new IOException(file + " exists but is not a directory.");
            }
            if (zExists) {
                String[] list = file.list();
                this.initialFiles = list;
                if (list == null) {
                    throw new IOException(file + " exists but cannot list contents.");
                }
                Arrays.sort(list);
                this.f24371size = this.initialFiles.length;
            } else {
                if (!file.mkdirs()) {
                    throw new IOException("Creation of " + file + " directory failed.");
                }
                this.f24371size = 0;
            }
            this.directory = file;
        }

        /* renamed from: delete */
        private void m18439delete(File file) {
            if (!file.delete()) {
                IOException iOException = new IOException("FileClientSessionCache: Failed to delete " + file + ".");
                FileClientSessionCache.f24369logger.log(Level.WARNING, iOException.getMessage(), (Throwable) iOException);
            }
            this.f24371size--;
        }

        private static String fileName(String str, int i) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            return str + "." + i;
        }

        private void indexFiles() {
            String[] strArr = this.initialFiles;
            if (strArr != null) {
                this.initialFiles = null;
                TreeSet<CacheFile> treeSet = new TreeSet();
                for (String str : strArr) {
                    if (!this.accessOrder.containsKey(str)) {
                        treeSet.add(new CacheFile(this.directory, str));
                    }
                }
                if (treeSet.isEmpty()) {
                    return;
                }
                Map<String, File> mapNewAccessOrder = newAccessOrder();
                for (CacheFile cacheFile : treeSet) {
                    mapNewAccessOrder.put(cacheFile.f24370name, cacheFile);
                }
                mapNewAccessOrder.putAll(this.accessOrder);
                this.accessOrder = mapNewAccessOrder;
            }
        }

        public static void logReadError(String str, File file, Throwable th) {
            FileClientSessionCache.f24369logger.log(Level.WARNING, "FileClientSessionCache: Error reading session data for " + str + " from " + file + ".", th);
        }

        public static void logWriteError(String str, File file, Throwable th) {
            FileClientSessionCache.f24369logger.log(Level.WARNING, "FileClientSessionCache: Error writing session data for " + str + " to " + file + ".", th);
        }

        private void makeRoom() {
            if (this.f24371size <= 12) {
                return;
            }
            indexFiles();
            int i = this.f24371size - 12;
            Iterator<File> it = this.accessOrder.values().iterator();
            do {
                m18439delete(it.next());
                it.remove();
                i--;
            } while (i > 0);
        }

        private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap(12, 0.75f, true);
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public synchronized byte[] getSessionData(String str, int i) {
            String strFileName = fileName(str, i);
            File file = this.accessOrder.get(strFileName);
            if (file == null) {
                String[] strArr = this.initialFiles;
                if (strArr == null) {
                    return null;
                }
                if (Arrays.binarySearch(strArr, strFileName) < 0) {
                    return null;
                }
                file = new File(this.directory, strFileName);
                this.accessOrder.put(strFileName, file);
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    new DataInputStream(fileInputStream).readFully(bArr);
                    return bArr;
                } catch (IOException e) {
                    logReadError(str, file, e);
                    return null;
                } finally {
                    C6343IoUtils.closeQuietly(fileInputStream);
                }
            } catch (FileNotFoundException e2) {
                logReadError(str, file, e2);
                return null;
            }
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public synchronized void putSessionData(SSLSession sSLSession, byte[] bArr) {
            String peerHost = sSLSession.getPeerHost();
            if (bArr == null) {
                throw new NullPointerException("sessionData == null");
            }
            String strFileName = fileName(peerHost, sSLSession.getPeerPort());
            File file = new File(this.directory, strFileName);
            boolean zExists = file.exists();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (!zExists) {
                    this.f24371size++;
                    makeRoom();
                }
                try {
                    try {
                        try {
                            fileOutputStream.write(bArr);
                        } catch (IOException e) {
                            logWriteError(peerHost, file, e);
                            try {
                                try {
                                    fileOutputStream.close();
                                } finally {
                                }
                            } catch (IOException e2) {
                                logWriteError(peerHost, file, e2);
                            }
                            m18439delete(file);
                        }
                        try {
                            fileOutputStream.close();
                            this.accessOrder.put(strFileName, file);
                        } catch (IOException e3) {
                            logWriteError(peerHost, file, e3);
                            m18439delete(file);
                        }
                    } catch (Throwable th) {
                        try {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                logWriteError(peerHost, file, e4);
                                throw th;
                            }
                            throw th;
                        } finally {
                        }
                    }
                } finally {
                }
            } catch (FileNotFoundException e5) {
                logWriteError(peerHost, file, e5);
            }
        }
    }

    private FileClientSessionCache() {
    }

    /* renamed from: reset */
    public static synchronized void m18438reset() {
        f24368caches.clear();
    }

    public static synchronized SSLClientSessionCache usingDirectory(File file) {
        C6286Impl c6286Impl;
        Map<File, C6286Impl> map = f24368caches;
        c6286Impl = map.get(file);
        if (c6286Impl == null) {
            c6286Impl = new C6286Impl(file);
            map.put(file, c6286Impl);
        }
        return c6286Impl;
    }
}
