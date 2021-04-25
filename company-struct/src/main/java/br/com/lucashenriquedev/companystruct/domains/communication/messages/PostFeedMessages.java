package br.com.lucashenriquedev.companystruct.domains.communication.messages;

public class PostFeedMessages {

    public static final String POST_NOT_FOUND = "Post não encontrado";

    public static final String TITLE_REQUIRED = "Título é obrigatório";
    public static final String MAX_LENGTH_CONTENT = "O conteúdo não pode ter mais do que 4096 caracteres";
    public static final String MAX_LENGTH_COMMENT = "O comentário não pode ter mais do que 1024 caracteres";
    public static final String INVALID_AUTHOR = "Autor inválido";
    public static final String REACTION_REQUIRED = "Uma reação é obrigatória";
    public static final String UNABLE_TO_SAVE = "Não foi possível salvar este post";
}
