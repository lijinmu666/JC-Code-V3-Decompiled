package org.bouncycastle.p358tsp.p360ers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ERSDirectoryDataGroup extends ERSDataGroup {
    public ERSDirectoryDataGroup(File file) {
        super(buildGroup(file));
    }

    private static List<InterfaceC6235ERSData> buildGroup(File file) {
        ERSCachingData eRSFileData;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("file reference does not refer to directory");
        }
        File[] fileArrListFiles = file.listFiles();
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (int i = 0; i != fileArrListFiles.length; i++) {
            if (!fileArrListFiles[i].isDirectory()) {
                eRSFileData = new ERSFileData(fileArrListFiles[i]);
            } else if (fileArrListFiles[i].listFiles().length != 0) {
                eRSFileData = new ERSDirectoryDataGroup(fileArrListFiles[i]);
            }
            arrayList.add(eRSFileData);
        }
        return arrayList;
    }

    public List<ERSFileData> getFiles() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.dataObjects.size(); i++) {
            if (this.dataObjects.get(i) instanceof ERSFileData) {
                arrayList.add((ERSFileData) this.dataObjects.get(i));
            }
        }
        return arrayList;
    }

    public List<ERSDirectoryDataGroup> getSubdirectories() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.dataObjects.size(); i++) {
            if (this.dataObjects.get(i) instanceof ERSDirectoryDataGroup) {
                arrayList.add((ERSDirectoryDataGroup) this.dataObjects.get(i));
            }
        }
        return arrayList;
    }
}
