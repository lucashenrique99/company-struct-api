package br.com.lucashenriquedev.companystruct.domains.communication.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import br.com.lucashenriquedev.companystruct.domains.users.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "feed_post_has_comments")
@Entity
public class PostComment extends AbstractModel {

    @NotEmpty
    @Column(length = 1024)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_feed_posts_author"),
            name = "author",
            nullable = false,
            referencedColumnName = "id"
    )
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_feed_post_has_comments_author"),
            name = "post",
            nullable = false,
            referencedColumnName = "id"
    )
    private PostFeed post;

    @NotNull
    private Boolean isVisible;
}
