package p094kotlin.p101io.p102path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p101io.CloseableKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p094kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000\u0086\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010'\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a$\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a$\u0010*\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010+\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a6\u0010,\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aE\u0010,\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u00104\u001a9\u00105\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u00108\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u00109\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a9\u0010:\u001a\u00020/*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u00107\u001a \u0010;\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010<\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010=\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010>\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010?\u001a\u00020/*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a(\u0010@\u001a\u00020/*\u00020\u00022\u0006\u0010A\u001a\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a,\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020C*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001aV\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010F*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00012\u0018\u0010G\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020I\u0012\u0004\u0012\u0002HF0HH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0ø\u0001\u0000¢\u0006\u0002\u0010J\u001aA\u0010K\u001a\u00020L*\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00012\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020L0HH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013ø\u0001\u0000\u001a \u0010N\u001a\u00020O*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a \u0010P\u001a\u00020L*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a$\u0010Q\u001a\u00020/*\u00020\u0002H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aE\u0010R\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aE\u0010V\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aA\u0010W\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(Xb\u0002\b0¢\u0006\u0002\u0010U\u001aE\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u00104\u001a6\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001a \u0010Z\u001a\u00020[*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aC\u0010\\\u001a\u0004\u0018\u00010]*\u00020\u00022\u0006\u0010^\u001a\u00020\u00012\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010_\u001aO\u0010`\u001a\u00020\u0002*\u00020\u00022\u0006\u0010^\u001a\u00020\u00012\b\u0010a\u001a\u0004\u0018\u00010]2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010b\u001aG\u0010c\u001a\u0004\u0018\u0001Hd\"\n\b\u0000\u0010d\u0018\u0001*\u00020e*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010f\u001aE\u0010g\u001a\u0002Hd\"\n\b\u0000\u0010d\u0018\u0001*\u00020e*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010f\u001a\"\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00022\n\u0010k\u001a\u0006\u0012\u0002\b\u00030lH\u0081\u0080\u0004b\u0002\bm\u001aE\u0010n\u001a\u0002Ho\"\n\b\u0000\u0010o\u0018\u0001*\u00020p*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010q\u001aO\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010]0r*\u00020\u00022\u0006\u0010S\u001a\u00020\u00012\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010s\u001a9\u0010t\u001a\u00020u*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010v\u001a(\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010a\u001a\u00020uH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a;\u0010x\u001a\u0004\u0018\u00010y*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010z\u001a,\u0010{\u001a\u00020\u0002*\u00020\u00022\u0006\u0010a\u001a\u00020yH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001a?\u0010|\u001a\b\u0012\u0004\u0012\u00020~0}*\u00020\u00022\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020602\"\u000206H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0002\u0010\u007f\u001a/\u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u00022\f\u0010a\u001a\b\u0012\u0004\u0012\u00020~0}H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a-\u0010\u0081\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0\u001aO\u0010\u0082\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0003\u0010\u0083\u0001\u001a!\u0010\u0084\u0001\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aF\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00022\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\bb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013b\u0002\b0¢\u0006\u0002\u0010U\u001aY\u0010\u0086\u0001\u001a\u00020\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u0089\u0001\u001a`\u0010\u0086\u0001\u001a\u00020\u00022\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0003\u0010\u008b\u0001\u001aL\u0010\u008c\u0001\u001a\u00020\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u008d\u0001\u001aS\u0010\u008c\u0001\u001a\u00020\u00022\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u001a\u0010S\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030T02\"\u0006\u0012\u0002\b\u00030TH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0003\u0010\u008e\u0001\u001a)\u0010\u008f\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010A\u001a\u00020\u0002H\u0087\u008a\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a)\u0010\u008f\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010A\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a%\u0010\u0090\u0001\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001a@\u0010\u0090\u0001\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\u0013\u0010\u0091\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000102\"\u00020\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013¢\u0006\u0003\u0010\u0092\u0001\u001a\"\u0010\u0093\u0001\u001a\u00020\u0002*\u00030\u0094\u0001H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\u0013\u001aT\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020I*\u00020\u00022\u0014\u00101\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u0096\u000102\"\u00030\u0096\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001¢\u0006\u0003\u0010\u0097\u0001\u001aY\u0010\u009b\u0001\u001a\u00020L*\u00020\u00022\u000e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u009d\u00012\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\b\u0002\u0010 \u0001\u001a\u00020/H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u001ar\u0010\u009b\u0001\u001a\u00020L*\u00020\u00022\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\b\u0002\u0010 \u0001\u001a\u00020/2\u001a\u0010¡\u0001\u001a\u0015\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020L0H¢\u0006\u0003\b£\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a^\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u009d\u00012\u001a\u0010¡\u0001\u001a\u0015\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020L0H¢\u0006\u0003\b£\u0001H\u0087\u0080\u0004b\u0012\b\u0098\u0001\u0012\r\b\u0099\u0001\u0012\b\b\fJ\u0004\b\t0\u001bb\r\b\u0007\u0012\t\b\b\u0012\u0005\b\b(\u009a\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\"-\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"-\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"-\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"2\u0010\u0010\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tr\u0002\b\u0013¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"-\u0010\u0014\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"n\u0010\u0017\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001ar\u0002\b\u001br6\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u001c\b\u001f\u0012\u0018\b\u000bB\u0014\b \u0012\b\b!\u0012\u0004\b\b(\u0014\u0012\u0006\b\"\u0012\u0002\b\f\u0012\n\b#\u0012\u0006\b\n0$8%r\u0002\b\u0013¢\u0006\f\u0012\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006¥\u0001"}, m4988d2 = {"name", BuildConfig.f24315FLAVOR, "Ljava/nio/file/Path;", "getName$annotations", "(Ljava/nio/file/Path;)V", "getName", "(Ljava/nio/file/Path;)Ljava/lang/String;", "Lkotlin/SinceKotlin;", "version", "1.5", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "extension", "getExtension$annotations", "getExtension", "pathString", "getPathString$annotations", "getPathString", "Lkotlin/internal/InlineOnly;", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "1.4", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/Deprecated;", "message", "Use invariantSeparatorsPathString property instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "imports", "level", "Lkotlin/DeprecationLevel;", "ERROR", "absolute", "absolutePathString", "relativeTo", "base", "relativeToOrSelf", "relativeToOrNull", "copyTo", "target", "overwrite", BuildConfig.f24315FLAVOR, "Lkotlin/IgnorableReturnValue;", "options", BuildConfig.f24315FLAVOR, "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "notExists", "isRegularFile", "isDirectory", "isSymbolicLink", "isExecutable", "isHidden", "isReadable", "isWritable", "isSameFileAs", "other", "listDirectoryEntries", BuildConfig.f24315FLAVOR, "glob", "useDirectoryEntries", "T", "block", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "forEachDirectoryEntry", BuildConfig.f24315FLAVOR, "action", "fileSize", BuildConfig.f24315FLAVOR, "deleteExisting", "deleteIfExists", "createDirectory", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectories", "createParentDirectories", "1.9", "moveTo", "fileStore", "Ljava/nio/file/FileStore;", "getAttribute", BuildConfig.f24315FLAVOR, "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "fileAttributesViewOrNull", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesView", "fileAttributeViewNotAvailable", BuildConfig.f24315FLAVOR, "path", "attributeViewClass", "Ljava/lang/Class;", "Lkotlin/PublishedApi;", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", BuildConfig.f24315FLAVOR, "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "setLastModifiedTime", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "setOwner", "getPosixFilePermissions", BuildConfig.f24315FLAVOR, "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "setPosixFilePermissions", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "readSymbolicLink", "createFile", "createTempFile", "prefix", "suffix", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempDirectory", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "div", "Path", "subpaths", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "toPath", "Ljava/net/URI;", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "Lkotlin/WasExperimental;", "markerClass", "2.1", "visitFileTree", "visitor", "Ljava/nio/file/FileVisitor;", "maxDepth", BuildConfig.f24315FLAVOR, "followLinks", "builderAction", "Lkotlin/io/path/FileVisitorBuilder;", "Lkotlin/ExtensionFunctionType;", "fileVisitor", "kotlin-stdlib-jdk7"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension(m6344value = {"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1218:1\n1#2:1219\n2068#3,2:1220\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n418#1:1220,2\n*E\n"})
/* loaded from: classes.dex */
public class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: Path */
    private static final Path m6246Path(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "get(...)");
        return path2;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path absolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path absolutePath = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final String absolutePathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: copyTo */
    private static final Path m6248copyTo(Path path, Path target, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    public static /* synthetic */ Path copyTo$default(Path path, Path target, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path createDirectories(Path path, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectories, "createDirectories(...)");
        return pathCreateDirectories;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path createDirectory(Path path, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateDirectory, "createDirectory(...)");
        return pathCreateDirectory;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path createFile(Path path, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateFile, "createFile(...)");
        return pathCreateFile;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path createLinkPointingTo(Path path, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Path pathCreateLink = Files.createLink(path, target);
        Intrinsics.checkNotNullExpressionValue(pathCreateLink, "createLink(...)");
        return pathCreateLink;
    }

    @SinceKotlin(m5061version = "1.9")
    @IgnorableReturnValue
    public static final Path createParentDirectories(Path path, FileAttribute<?>... attributes) throws FileAlreadyExistsException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path parent = path.getParent();
        if (parent != null && !Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr = (FileAttribute[]) Arrays.copyOf(attributes, attributes.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length)), "createDirectories(...)");
            } catch (FileAlreadyExistsException e) {
                if (!Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e;
                }
            }
        }
        return path;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path createSymbolicLinkPointingTo(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateSymbolicLink, "createSymbolicLink(...)");
        return pathCreateSymbolicLink;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path createTempDirectory(String str, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    public static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] attributes, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path createTempFile(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    public static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] attributes, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final void deleteExisting(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Files.delete(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final boolean deleteIfExists(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: div */
    private static final Path m6251div(Path path, Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path pathResolve = path.resolve(other);
        Intrinsics.checkNotNullExpressionValue(pathResolve, "resolve(...)");
        return pathResolve;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: exists */
    private static final boolean m6252exists(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @PublishedApi
    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> attributeViewClass) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        if (v != null) {
            return v;
        }
        Intrinsics.reifiedOperationMarker(4, "V");
        fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final long fileSize(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.size(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final FileStore fileStore(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        FileStore fileStore = Files.getFileStore(path);
        Intrinsics.checkNotNullExpressionValue(fileStore, "getFileStore(...)");
        return fileStore;
    }

    @SinceKotlin(m5061version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        builderAction.mo2237invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.m6226build();
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final void forEachDirectoryEntry(Path path, String glob, Function1<? super Path, C1133Unit> action) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                action.mo2237invoke(it.next());
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    public static /* synthetic */ void forEachDirectoryEntry$default(Path path, String glob, Function1 action, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            glob = "*";
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                action.mo2237invoke(it.next());
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Object getAttribute(Path path, String attribute, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    public static final String getExtension(Path path) {
        String string;
        String strSubstringAfterLast;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringAfterLast = StringsKt.substringAfterLast(string, '.', BuildConfig.f24315FLAVOR)) == null) ? BuildConfig.f24315FLAVOR : strSubstringAfterLast;
    }

    @SinceKotlin(m5061version = "1.5")
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    private static final String getInvariantSeparatorsPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return getInvariantSeparatorsPathString(path);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", m5048imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static final String getInvariantSeparatorsPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String separator = path.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(separator, "/")) {
            return path.toString();
        }
        String string = path.toString();
        Intrinsics.checkNotNull(separator);
        return StringsKt.replace$default(string, separator, "/", false, 4, (Object) null);
    }

    @SinceKotlin(m5061version = "1.5")
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    /* renamed from: getName */
    public static final String m6253getName(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? BuildConfig.f24315FLAVOR : string;
    }

    @SinceKotlin(m5061version = "1.5")
    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static final String getNameWithoutExtension(Path path) {
        String string;
        String strSubstringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(string, ".", (String) null, 2, (Object) null)) == null) ? BuildConfig.f24315FLAVOR : strSubstringBeforeLast$default;
    }

    @SinceKotlin(m5061version = "1.5")
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final UserPrincipal getOwner(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    private static final String getPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.toString();
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isDirectory(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isExecutable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isExecutable(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isHidden(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isHidden(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isReadable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isReadable(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isRegularFile(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isSameFileAs(Path path, Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Files.isSameFile(path, other);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isSymbolicLink(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean isWritable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isWritable(path);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final List<Path> listDirectoryEntries(Path path, String glob) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            List<Path> list = CollectionsKt.m5899toList(directoryStreamNewDirectoryStream);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            return list;
        } finally {
        }
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "*";
        }
        return listDirectoryEntries(path, str);
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: moveTo */
    private static final Path m6255moveTo(Path path, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    public static /* synthetic */ Path moveTo$default(Path path, Path target, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final boolean notExists(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        A a = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(a, "readAttributes(...)");
        return a;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path readSymbolicLink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path symbolicLink = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "readSymbolicLink(...)");
        return symbolicLink;
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Path relativeTo(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e);
        }
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Path relativeToOrNull(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Path relativeToOrSelf(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path pathRelativeToOrNull = relativeToOrNull(path, base);
        return pathRelativeToOrNull == null ? path : pathRelativeToOrNull;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path setAttribute(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        Path attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attribute2, "setAttribute(...)");
        return attribute2;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path setLastModifiedTime(Path path, FileTime value) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime(path, value);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final Path setOwner(Path path, UserPrincipal value) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path owner = Files.setOwner(path, value);
        Intrinsics.checkNotNullExpressionValue(owner, "setOwner(...)");
        return owner;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, value);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: toPath */
    private static final Path m6256toPath(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Path path = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    private static final <T> T useDirectoryEntries(Path path, String glob, Function1<? super Sequence<? extends Path>, ? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(block, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            T tMo2237invoke = block.mo2237invoke(CollectionsKt.asSequence(directoryStreamNewDirectoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return tMo2237invoke;
        } finally {
        }
    }

    public static /* synthetic */ Object useDirectoryEntries$default(Path path, String glob, Function1 block, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            glob = "*";
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(block, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            Object objMo2237invoke = block.mo2237invoke(CollectionsKt.asSequence(directoryStreamNewDirectoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(directoryStreamNewDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return objMo2237invoke;
        } finally {
        }
    }

    @SinceKotlin(m5061version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void visitFileTree(Path path, FileVisitor<Path> visitor, int i, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Files.walkFileTree(path, z ? C1159SetsKt.m5992setOf(FileVisitOption.FOLLOW_LINKS) : C1159SetsKt.emptySet(), i, visitor);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        visitFileTree(path, (FileVisitor<Path>) fileVisitor, i, z);
    }

    @SinceKotlin(m5061version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    /* renamed from: walk */
    public static final Sequence<Path> m6257walk(Path path, PathWalkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PathTreeWalk(path, options);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: Path */
    private static final Path m6247Path(String base, String... subpaths) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(subpaths, "subpaths");
        Path path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Path createTempDirectory(Path path, String str, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory, "createTempDirectory(...)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempDirectory2, "createTempDirectory(...)");
        return pathCreateTempDirectory2;
    }

    @SinceKotlin(m5061version = "1.5")
    public static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            Intrinsics.checkNotNullExpressionValue(pathCreateTempFile, "createTempFile(...)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(pathCreateTempFile2, "createTempFile(...)");
        return pathCreateTempFile2;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: div */
    private static final Path m6250div(Path path, String other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path pathResolve = path.resolve(other);
        Intrinsics.checkNotNullExpressionValue(pathResolve, "resolve(...)");
        return pathResolve;
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: moveTo */
    private static final Path m6254moveTo(Path path, Path target, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathMove, "move(...)");
        return pathMove;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(options, "options");
        Map<String, Object> attributes2 = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attributes2, "readAttributes(...)");
        return attributes2;
    }

    public static /* synthetic */ void visitFileTree$default(Path path, int i, boolean z, Function1 function1, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        visitFileTree(path, i, z, (Function1<? super FileVisitorBuilder, C1133Unit>) function1);
    }

    @SinceKotlin(m5061version = "1.5")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: copyTo */
    private static final Path m6249copyTo(Path path, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(pathCopy, "copy(...)");
        return pathCopy;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(m5061version = "2.1")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void visitFileTree(Path path, int i, boolean z, Function1<? super FileVisitorBuilder, C1133Unit> builderAction) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        visitFileTree(path, fileVisitor(builderAction), i, z);
    }
}
