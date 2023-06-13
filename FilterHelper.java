package com.rsa.common.search;

import java.util.Date;

import com.rsa.common.GUID;
import com.rsa.common.GUIDWrapper;
import com.rsa.common.search.And;
import com.rsa.common.search.Empty;
import com.rsa.common.search.Equal;
import com.rsa.common.search.Filter;
import com.rsa.common.search.Greater;
import com.rsa.common.search.Less;
import com.rsa.common.search.Like;
import com.rsa.common.search.Not;
import com.rsa.common.search.Or;
import com.rsa.common.search.Present;
import com.rsa.common.search.Simple;
import com.rsa.reportframework.common.Parameter;

public class FilterHelper {
  /**
   * This method creates a new filter that combines two filters with the AND operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter and(final Filter filter1, final Filter filter2) {
      return Filter.and(filter1, filter2);
  }

  /**
   * This method creates a new filter that combines three filters with the AND operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   * @param filter3 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter and(final Filter filter1, final Filter filter2,
      final Filter filter3) {
      return and(and(filter1, filter2), filter3);
  }

  /**
   * This method creates a new filter that combines four filters with the AND operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   * @param filter3 a <code>Filter</code> value
   * @param filter4 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter and(final Filter filter1, final Filter filter2,
      final Filter filter3, final Filter filter4) {
      return and(and(filter1, filter2, filter3), filter4);
  }

  /**
   * This method creates a new filter that combines two filters with the inclusive OR
   * operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter or(final Filter filter1, final Filter filter2) {
      return Filter.or(filter1, filter2);
  }

  /**
   * This method creates a new filter that combines three filters with the inclusive OR
   * operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   * @param filter3 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter or(final Filter filter1, final Filter filter2,
      final Filter filter3) {
      return or(or(filter1, filter2), filter3);
  }

  /**
   * This method creates a new filter that combines four filters with the inclusive OR
   * operation.
   *
   * @param filter1 a <code>Filter</code> value
   * @param filter2 a <code>Filter</code> value
   * @param filter3 a <code>Filter</code> value
   * @param filter4 a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter or(final Filter filter1, final Filter filter2,
      final Filter filter3, final Filter filter4) {
      return or(or(filter1, filter2, filter3), filter4);
  }

  /**
   * This method creates a new filter which negates the filter passed in.
   *
   * @param filter a <code>Filter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter not(final Filter filter) {
      return Filter.not(filter);
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final String value) {
      return simple(new Equal(), attributeName, value);
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>Date</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final Date value) {
      return simple(new Equal(), attributeName, value);
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a generic <code>Parameter</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final Parameter value) {
      return simple(new Equal(), attributeName, value);
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>short</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final short value) {
      return simple(new Equal(), attributeName, new Short(value));
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value an <code>int</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final int value) {
      return simple(new Equal(), attributeName, new Integer(value));
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>long</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final long value) {
      return simple(new Equal(), attributeName, new Long(value));
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>boolean</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final boolean value) {
      return simple(new Equal(), attributeName, new Boolean(value));
  }

  /**
   * This method creates a new filter that tests for equality.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>GUID</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter equal(final String attributeName, final GUID value) {
      GUIDWrapper wrapper = new GUIDWrapper();
      wrapper.setTypedGuid(value.toString());

      return simple(new Equal(), attributeName, wrapper);
  }

  /**
   * This method creates a new filter that matches any attribute greater than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter greater(final String attributeName, final String value) {
      return simple(new Greater(), attributeName, value);
  }

  /**
   * This method creates a new filter that matches any attribute greater than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>Date</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter greater(final String attributeName, final Date value) {
      return simple(new Greater(), attributeName, value);
  }

  /**
   * This method creates a new filter that matches any attribute greater than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>short</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter greater(final String attributeName, final short value) {
      return simple(new Greater(), attributeName, new Short(value));
  }

  /**
   * This method creates a new filter that matches any attribute greater than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value an <code>int</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter greater(final String attributeName, final int value) {
      return simple(new Greater(), attributeName, new Integer(value));
  }

  /**
   * This method creates a new filter that matches any attribute greater than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>long</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter greater(final String attributeName, final long value) {
      return simple(new Greater(), attributeName, new Long(value));
  }

  /**
   * This method creates a new filter that matches any attribute less than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter less(final String attributeName, final String value) {
      return simple(new Less(), attributeName, value);
  }

  /**
   * This method creates a new filter that matches any attribute less than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>Date</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter less(final String attributeName, final Date value) {
      return simple(new Less(), attributeName, value);
  }

  /**
   * This method creates a new filter that matches any attribute less than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>short</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter less(final String attributeName, final short value) {
      return simple(new Less(), attributeName, new Short(value));
  }

  /**
   * This method creates a new filter that matches any attribute less than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value an <code>int</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter less(final String attributeName, final int value) {
      return simple(new Less(), attributeName, new Integer(value));
  }

  /**
   * This method creates a new filter that matches any attribute less than the
   * specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>long</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter less(final String attributeName, final long value) {
      return simple(new Less(), attributeName, new Long(value));
  }

  /**
   * This method creates a new filter that checks for presence of the attribute. In
   * SQL, that means that the column value is not NULL.
   *
   * @param attributeName a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter present(final String attributeName) {
      return simple(new Present(), attributeName);
  }

  /**
   * This method creates a new filter that matches any attribute approximately like
   * the specified value.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter like(final String attributeName, final String value) {
      return simple(new Like(), attributeName, value);
  }

  /**
   * This method creates a new filter that tests if the attribute begins with the
   * specified string.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter startsWith(final String attributeName, final String value) {
      return simple(new Like(), attributeName, value + "*");
  }

  /**
   * This method creates a new filter that tests if the attribute ends with the
   * specified string.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter endsWith(final String attributeName, final String value) {
      return simple(new Like(), attributeName, "*" + value);
  }

  /**
   * This method creates a new filter that tests if the attribute contains the
   * specified string.
   *
   * @param attributeName a <code>String</code> value
   * @param value a <code>String</code> value
   *
   * @return A <code>Filter</code> value
   */
  public static Filter contains(final String attributeName, final String value) {
      return simple(new Like(), attributeName, "*" + value + "*");
  }

  /**
   * This method creates a new empty filter that matches everything.
   *
   * @return A <code>Filter</code> value
   */
  public static Filter empty() {
      return Filter.empty();
  }

  /**
   * New simple filter.
   * @param type any type of binary comparator, such as {@link Like}, or {@link Less}
   * @param attr attribute name for the comparison
   * @param value operand for the comparison
   * @return new filter
   */
  private static Filter simple(Object type, String attr, Object value) {
      Simple simple = new Simple();
      simple.setCore(true);
      simple.setType((com.rsa.common.search.Type)type);
      simple.setAttr(attr);
      simple.setValue(value);

      Filter filter = new Filter();
      filter.setComp(simple);

      return filter;
  }

  /**
   * New simple filter.
   * @param type any type of unary filter operator, such as {@link Not}
   * @param attr attribute name for comparison
   * @return new filter
   */
  private static Filter simple(Object type, String attr) {
    Simple simple = new Simple();
    simple.setCore(true);
    simple.setType((com.rsa.common.search.Type)type);
    simple.setAttr(attr);
    simple.setValue(null);

    Filter filter = new Filter();
    filter.setComp(simple);

    return filter;
  }
}
