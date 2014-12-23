

package net.smartcosmos.pojo.event;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.smartcosmos.model.context.IAccount;
import net.smartcosmos.model.context.IUser;
import net.smartcosmos.model.event.EventType;
import net.smartcosmos.model.event.IEvent;
import net.smartcosmos.pojo.base.DomainResource;
import net.smartcosmos.pojo.context.Account;
import net.smartcosmos.pojo.context.User;
import net.smartcosmos.util.json.JsonGenerationView;

public class Event extends DomainResource<IEvent> implements IEvent
{
    @JsonView(JsonGenerationView.Minimum.class)
    @JsonDeserialize(as = User.class)
    protected IUser user;

    @JsonView(JsonGenerationView.Restricted.class)
    @JsonDeserialize(as = Account.class)
    protected IAccount account;

    @JsonView(JsonGenerationView.Minimum.class)
    protected EventType eventType;

    @JsonView(JsonGenerationView.Minimum.class)
    protected String source;

    @Override
    public IUser getUser()
    {
        return user;
    }

    @Override
    public void setUser(IUser user)
    {
        this.user = user;
    }

    @Override
    public EventType getEventType()
    {
        return eventType;
    }

    @Override
    public void setEventType(EventType eventType)
    {
        this.eventType = eventType;
    }

    @Override
    public String getSource()
    {
        return source;
    }

    @Override
    public void setSource(String source)
    {
        this.source = source;
    }

    public IAccount getAccount()
    {
        return account;
    }

    public void setAccount(IAccount account)
    {
        this.account = account;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Event event = (Event) o;

        if (account != null ? !account.equals(event.account) : event.account != null) return false;
        if (eventType != event.eventType) return false;
        if (source != null ? !source.equals(event.source) : event.source != null) return false;
        if (user != null ? !user.equals(event.user) : event.user != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + eventType.hashCode();
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Event{" +
                super.toString() +
                "user=" + user +
                ", account=" + account +
                ", eventType=" + eventType +
                ", source='" + source + '\'' +
                '}';
    }
}
