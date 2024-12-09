package net.sf.jxls.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {
 @Test
 public void testReplaceExpressions() {
 // no expression -> no replacement
 Assert.assertEquals("const", Util.replaceExpressions("const", "root", "root1"));
 Assert.assertEquals("root", Util.replaceExpressions("root", "root", "root1"));

 // expression consists of a single identifier -> replacing
 Assert.assertEquals("${root1}", Util.replaceExpressions("${root}", "root", "root1"));

 // expression has periods, root matches -> replacing
 Assert.assertEquals("${root1.rootId}", Util.replaceExpressions("${root.rootId}", "root", "root1"));

 // expression has periods, non-root matches -> no replacement
 Assert.assertEquals("${rootA.root}", Util.replaceExpressions("${rootA.root}", "root", "root1"));
 }
}