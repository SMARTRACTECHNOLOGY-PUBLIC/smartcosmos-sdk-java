package com.snapbundle.pojo.context;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snapbundle.model.base.EntityReferenceType;
import com.snapbundle.model.context.IRelationship;
import com.snapbundle.model.context.RelationshipType;
import com.snapbundle.pojo.base.ReferentialObject;
import com.snapbundle.util.JsonGenerationView;

import java.io.IOException;

public class Relationship extends ReferentialObject<IRelationship> implements IRelationship
{
    @JsonView(JsonGenerationView.Minimum.class)
    protected EntityReferenceType relatedEntityReferenceType;

    @JsonView(JsonGenerationView.Minimum.class)
    protected String relatedReferenceURN;

    @JsonView(JsonGenerationView.Minimum.class)
    protected RelationshipType relationshipType;

    @Override
    public RelationshipType getRelationshipType()
    {
        return relationshipType;
    }

    @Override
    public void setRelationshipType(RelationshipType relationshipType)
    {
        this.relationshipType = relationshipType;
    }

    @Override
    public String getRelatedReferenceUrn()
    {
        return relatedReferenceURN;
    }

    @Override
    public void setRelatedReferenceUrn(String urn)
    {
        this.relatedReferenceURN = urn;
    }

    @Override
    public EntityReferenceType getRelatedEntityReferenceType()
    {
        return relatedEntityReferenceType;
    }

    @Override
    public void setRelatedEntityReferenceType(EntityReferenceType entityReferenceType)
    {
        this.relatedEntityReferenceType = entityReferenceType;
    }

    @Override
    public void copy(IRelationship object)
    {
        throw new UnsupportedOperationException("POJO doesn't support copying");
    }

    public static IRelationship fromJson(String json) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Relationship.class);
    }
}