package moe.banana.jsonapi2;

public class ObjectDocument<DATA extends ResourceIdentifier> extends Document {

    /**
     * NOTE In JSON API Spec version 1.0, a Document may contains no data or "null" data.
     *      The field `hasData` denotes whether the document contains a nullable data.
     */
    private boolean hasData = false;

    private DATA data = null;

    public ObjectDocument() {
    }

    public ObjectDocument(DATA data) {
        set(data);
    }

    public ObjectDocument(Document document) {
        super(document);
    }

    public void set(DATA data) {
        this.hasData = true;
        bindDocument(null, this.data, -1);
        bindDocument(this, data, -1);
        this.data = data;
    }

    public DATA get() {
        return data;
    }

    @Deprecated
    public void setNull(boolean isNull) {
        hasData = !isNull;
    }

    @Deprecated
    public boolean isNull() {
        return hasData && data == null;
    }

    public boolean hasData() {
        return hasData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ObjectDocument<?> that = (ObjectDocument<?>) o;

        if (hasData != that.hasData) return false;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + (hasData ? 1 : 0);
        return result;
    }
}
