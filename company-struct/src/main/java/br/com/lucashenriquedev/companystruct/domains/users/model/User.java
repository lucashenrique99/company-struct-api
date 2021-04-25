package br.com.lucashenriquedev.companystruct.domains.users.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = "email")
})
public class User extends AbstractModel {

    @NotEmpty
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "users_has_permissions",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_users_has_permissions_user")),
            inverseJoinColumns = @JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "fk_users_has_permissions_permission")))
    private Set<Permission> permissions;


}
