
package dnomyar.layouttest.apis.nytimes.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private String section;
    private String subsection;
    private String title;
    private String _abstract;
    private String url;
    private String byline;
    private String thumbnailStandard;
    private String itemType;
    private String source;
    private String updatedDate;
    private String createdDate;
    private String publishedDate;
    private String materialTypeFacet;
    private String kicker;
    private String subheadline;
    private List<String> desFacet = new ArrayList<String>();
    private List<String> orgFacet = new ArrayList<String>();
    private List<String> perFacet = new ArrayList<String>();
    private String geoFacet;
    private Object relatedUrls;
    private List<Multimedium> multimedia = new ArrayList<Multimedium>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The section
     */
    public String getSection() {
        return section;
    }

    /**
     * 
     * @param section
     *     The section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * 
     * @return
     *     The subsection
     */
    public String getSubsection() {
        return subsection;
    }

    /**
     * 
     * @param subsection
     *     The subsection
     */
    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The _abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * 
     * @param _abstract
     *     The abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The byline
     */
    public String getByline() {
        return byline;
    }

    /**
     * 
     * @param byline
     *     The byline
     */
    public void setByline(String byline) {
        this.byline = byline;
    }

    /**
     * 
     * @return
     *     The thumbnailStandard
     */
    public String getThumbnailStandard() {
        return thumbnailStandard;
    }

    /**
     * 
     * @param thumbnailStandard
     *     The thumbnail_standard
     */
    public void setThumbnailStandard(String thumbnailStandard) {
        this.thumbnailStandard = thumbnailStandard;
    }

    /**
     * 
     * @return
     *     The itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 
     * @param itemType
     *     The item_type
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The updatedDate
     */
    public String getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 
     * @param updatedDate
     *     The updated_date
     */
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 
     * @return
     *     The createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * 
     * @param createdDate
     *     The created_date
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 
     * @return
     *     The publishedDate
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * 
     * @param publishedDate
     *     The published_date
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * 
     * @return
     *     The materialTypeFacet
     */
    public String getMaterialTypeFacet() {
        return materialTypeFacet;
    }

    /**
     * 
     * @param materialTypeFacet
     *     The material_type_facet
     */
    public void setMaterialTypeFacet(String materialTypeFacet) {
        this.materialTypeFacet = materialTypeFacet;
    }

    /**
     * 
     * @return
     *     The kicker
     */
    public String getKicker() {
        return kicker;
    }

    /**
     * 
     * @param kicker
     *     The kicker
     */
    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    /**
     * 
     * @return
     *     The subheadline
     */
    public String getSubheadline() {
        return subheadline;
    }

    /**
     * 
     * @param subheadline
     *     The subheadline
     */
    public void setSubheadline(String subheadline) {
        this.subheadline = subheadline;
    }

    /**
     * 
     * @return
     *     The desFacet
     */
    public List<String> getDesFacet() {
        return desFacet;
    }

    /**
     * 
     * @param desFacet
     *     The des_facet
     */
    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    /**
     * 
     * @return
     *     The orgFacet
     */
    public List<String> getOrgFacet() {
        return orgFacet;
    }

    /**
     * 
     * @param orgFacet
     *     The org_facet
     */
    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    /**
     * 
     * @return
     *     The perFacet
     */
    public List<String> getPerFacet() {
        return perFacet;
    }

    /**
     * 
     * @param perFacet
     *     The per_facet
     */
    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    /**
     * 
     * @return
     *     The geoFacet
     */
    public String getGeoFacet() {
        return geoFacet;
    }

    /**
     * 
     * @param geoFacet
     *     The geo_facet
     */
    public void setGeoFacet(String geoFacet) {
        this.geoFacet = geoFacet;
    }

    /**
     * 
     * @return
     *     The relatedUrls
     */
    public Object getRelatedUrls() {
        return relatedUrls;
    }

    /**
     * 
     * @param relatedUrls
     *     The related_urls
     */
    public void setRelatedUrls(Object relatedUrls) {
        this.relatedUrls = relatedUrls;
    }

    /**
     * 
     * @return
     *     The multimedia
     */
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    /**
     * 
     * @param multimedia
     *     The multimedia
     */
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static class ResultDeserializer implements JsonDeserializer<Result> {

        @Override
        public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            Result result = new Result();
            result.setTitle(jsonObject.get("title").getAsString());
            result.setSection(jsonObject.get("section").getAsString());
            result.setSubsection(jsonObject.get("subsection").getAsString());
            result.setAbstract(jsonObject.get("abstract").getAsString());
            result.setUrl(jsonObject.get("url").getAsString());
            result.setByline(jsonObject.get("byline").getAsString());
            result.setThumbnailStandard(jsonObject.get("thumbnail_standard").getAsString());
            result.setItemType(jsonObject.get("item_type").getAsString());
            result.setSource(jsonObject.get("source").getAsString());
            result.setUpdatedDate(jsonObject.get("updated_date").getAsString());
            result.setCreatedDate(jsonObject.get("created_date").getAsString());
            result.setPublishedDate(jsonObject.get("published_date").getAsString());
            result.setMaterialTypeFacet(jsonObject.get("material_type_facet").getAsString());
            result.setKicker(jsonObject.get("kicker").getAsString());
            result.setSubheadline(jsonObject.get("subheadline").getAsString());

            if (jsonObject.get("des_facet").isJsonArray()) {
                JsonArray s = jsonObject.get("des_facet").getAsJsonArray();
                List<String> desFacet = new Gson().fromJson(jsonObject.get("des_facet").getAsJsonArray(), new TypeToken<List<String>>(){}.getType());
                result.setDesFacet(desFacet);
            }

            if (jsonObject.get("org_facet").isJsonArray()) {
                List<String> orgFacet = new Gson().fromJson(jsonObject.get("org_facet").getAsJsonArray(), new TypeToken<List<String>>(){}.getType());
                result.setOrgFacet(orgFacet);
            }

            if (jsonObject.get("per_facet").isJsonArray()) {
                List<String> perFacet = new Gson().fromJson(jsonObject.get("per_facet").getAsJsonArray(), new TypeToken<List<String>>(){}.getType());
                result.setPerFacet(perFacet);
            }

            if (jsonObject.get("geo_facet").isJsonArray()) {
                List<String> geoFacet = new Gson().fromJson(jsonObject.get("geo_facet").getAsJsonArray(), new TypeToken<List<String>>(){}.getType());
                result.setPerFacet(geoFacet);
            }

            if (jsonObject.get("related_urls").isJsonArray()) {
//                List<String> relatedUrls = new Gson().fromJson(jsonObject.get("related_urls").getAsJsonArray(), new TypeToken<List<String>>(){}.getType());
//                result.setRelatedUrls(relatedUrls);
            }

            if (jsonObject.get("multimedia").isJsonArray()) {
                List<Multimedium> multimedia = new Gson().fromJson(jsonObject.get("multimedia").getAsJsonArray(), new TypeToken<List<Multimedium>>(){}.getType());
                result.setMultimedia(multimedia);
            }

            return result;
        }
    }
}
