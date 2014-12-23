

package net.smartcosmos.pojo;

import net.smartcosmos.model.base.EntityReferenceType;
import net.smartcosmos.model.context.IAccount;
import net.smartcosmos.model.context.IMetadata;
import net.smartcosmos.model.context.MetadataDataType;
import net.smartcosmos.pojo.context.Account;
import net.smartcosmos.pojo.context.Metadata;
import net.smartcosmos.pojo.context.TypeSafeMetadata;
import net.smartcosmos.util.json.JsonGenerationView;
import net.smartcosmos.util.json.JsonUtil;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class JsonTest
{
    @Test
    public void testAccount() throws IOException
    {
        String urn = "net.smartcosmos";
        String name = "Test Account";
        String description = "My test Description";

        IAccount testAccount = new Account();
        testAccount.setUrn(urn);
        testAccount.setName(name);
        testAccount.setDescription(description);
        testAccount.setActive(true);

        String json = JsonUtil.toJson(testAccount, JsonGenerationView.Full.class);
        assertTrue(json != null);

        System.out.println(json);

        IAccount jsonAccount = JsonUtil.fromJson(json, Account.class);

        assertTrue(jsonAccount.getName().equals(name));
        assertTrue(jsonAccount.getDescription().equals(description));
        assertTrue(jsonAccount.getUrn().equals(urn));
    }

    @Test
    public void testMetadataObject() throws IOException
    {
        final String MESSAGE = "alphabet soup";

        IMetadata metadataObject = new Metadata.MetadataObjectBuilder(MetadataDataType.StringType)
                .setEntityReferenceType(EntityReferenceType.Device)
                .setReferenceUrn("urn:uuid:12345")
                .setKey("foo")
                .setStringValue(MESSAGE)
                .build();

        String json = JsonUtil.toJson(metadataObject, JsonGenerationView.Minimum.class);
        System.out.println(json);

        IMetadata reconstituted = JsonUtil.fromJson(json, Metadata.class);

        TypeSafeMetadata<String> m = new TypeSafeMetadata<>(reconstituted);

        Assert.assertEquals(MESSAGE, m.getValue());
    }

    @Test
    public void testJsonMetadataObject() throws IOException, JSONException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("foo", "bar");
        jsonObject.put("now", true);

        IMetadata metadataObject = new Metadata.MetadataObjectBuilder(MetadataDataType.JSONType)
                .setEntityReferenceType(EntityReferenceType.Device)
                .setReferenceUrn("urn:uuid:12345")
                .setKey("foo")
                .setJsonValue(jsonObject)
                .build();

        String json = JsonUtil.toJson(metadataObject, JsonGenerationView.Minimum.class);
        System.out.println(json);

        IMetadata reconstituted = JsonUtil.fromJson(json, Metadata.class);

        TypeSafeMetadata<JSONObject> m = new TypeSafeMetadata<>(reconstituted);

        Assert.assertEquals(jsonObject.get("foo"), m.getValue().get("foo"));
    }

}
