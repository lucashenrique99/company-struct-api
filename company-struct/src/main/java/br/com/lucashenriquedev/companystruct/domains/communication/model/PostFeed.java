package br.com.lucashenriquedev.companystruct.domains.communication.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import br.com.lucashenriquedev.companystruct.domains.users.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "feed_posts")
@Entity
public class PostFeed extends AbstractModel {

    @NotEmpty
    private String title;

    @Column(length = 4096)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_feed_posts_author"),
            name = "author",
            nullable = false,
            referencedColumnName = "id"
    )
    private User author;

    @NotNull
    private Boolean isVisible;

    @OneToMany(mappedBy = "post")
    private List<PostReaction> reactions;

    @OneToMany(mappedBy = "post")
    private List<PostComment> comments;

}
