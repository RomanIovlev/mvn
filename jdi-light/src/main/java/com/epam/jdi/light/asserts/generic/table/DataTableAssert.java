package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.TableMatcher;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.Matchers.*;

public class DataTableAssert<D>
        extends BaseTableAssert<DataTable<?, D>, DataTableAssert<D>> {

    public DataTableAssert(DataTable<?, D>  table) {
        super(table);
    }

    /**
     * Check that the table has rows that meet expected condition
     * @param condition to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has rows that meet expected condition")
    public DataTableAssert<D> row(JFunc1<D,Boolean> condition) {
        jdiAssert(table().data(condition), not(nullValue()));
        return this;
    }

    /**
     * Check that the table has row that has expected data
     * @param data to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has {0}")
    public DataTableAssert<D> row(D data) {
        return row(d -> d.equals(data));
    }

    public Compare exact(int count) {
        return new Compare(count, this, true);
    }
    public Compare atLeast(int count) {
        return new Compare(count, this, false);
    }
    public Compare no() {
        return exact(0);
    }
    public Compare all() {
        return exact(table().count());
    }
    public Compare onlyOne() {
        return exact(1);
    }

    public class Compare {
        public int count;
        public String name;
        public String type;
        DataTableAssert<D> dtAssert;
        boolean exact;
        private Compare(int count, DataTableAssert<D> dtAssert, boolean exact) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = dtAssert.name;
        }

        /**
         * Check that the table has rows that meet expected condition
         * @param condition to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' has {type} '{count}' rows that meet expected condition")
        public DataTableAssert<D> rows(JFunc1<D,Boolean> condition) {
            jdiAssert(exact
                ? table().datas(condition)
                : table().datas(condition, count),
            hasSize(count));
            return dtAssert;
        }

        /**
         * Check that the table has rows that have expected data
         * @param data to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' has {type} '{count}' '{0}'")
        public DataTableAssert<D> rows(D data) {
            return rows(d -> d.equals(data));
        }

        /**
         * Make sure that the table has at least a certain number of the specified line
         * @param matchers to compare
         */
        @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
        public DataTableAssert<D> rows(TableMatcher... matchers) {
            jdiAssert(TABLE_MATCHER.execute(table(), matchers).size(),
                    greaterThan(table().header().size()*count-1));
            return dtAssert;
        }
    }
}
