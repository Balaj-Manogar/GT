package org.baali.relation;

import org.baali.base.IPerson;

class RelationKey
{
    private String relationKey;
    private IRelationOptions greaterId;
    private IPerson.Gender gender;
    private String relationType;
    private String description;

    public RelationKey(String relationKey, IRelationOptions greaterId, IPerson.Gender gender, String relationType)
    {
        this.relationKey = relationKey;
        this.greaterId = greaterId;
        this.gender = gender;
        this.relationType = relationType;
    }

    public RelationKey(String relationKey, IRelationOptions greaterId, IPerson.Gender gender, String relationType, String
            des)
    {
        this(relationKey, greaterId, gender, relationType);
        this.description = des;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRelationKey()
    {
        return relationKey;
    }

    public void setRelationKey(String relationKey)
    {
        this.relationKey = relationKey;
    }

    public IRelationOptions getGreaterId()
    {
        return greaterId;
    }

    public void setGreaterId(IRelationOptions greaterId)
    {
        this.greaterId = greaterId;
    }

    public IPerson.Gender getGender()
    {
        return gender;
    }

    public void setGender(IPerson.Gender gender)
    {
        this.gender = gender;
    }

    public String getRelationType()
    {
        return relationType;
    }

    public void setRelationType(String relationType)
    {
        this.relationType = relationType;
    }
}
