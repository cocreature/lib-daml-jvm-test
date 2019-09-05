package com.digitalasset.testing.utils;

import com.digitalasset.daml_lf.DamlLf1;
import org.junit.Assert;
import org.junit.Test;

public class PackageUtilsTest {

  @Test
  public void dottedNameToString_returns_single_segment_as_is() {
    DamlLf1.DottedName dottedName = DamlLf1.DottedName.newBuilder().addSegments("Foo").build();
    String result = PackageUtils.dottedNameToString(dottedName);
    Assert.assertEquals("Foo", result);
  }

  @Test
  public void dottedNameToString_separates_segments_with_dot() {
    DamlLf1.DottedName dottedName =
        DamlLf1.DottedName.newBuilder()
            .addSegments("Foo")
            .addSegments("Bar")
            .addSegments("Baz")
            .build();
    String result = PackageUtils.dottedNameToString(dottedName);
    Assert.assertEquals("Foo.Bar.Baz", result);
  }
}
