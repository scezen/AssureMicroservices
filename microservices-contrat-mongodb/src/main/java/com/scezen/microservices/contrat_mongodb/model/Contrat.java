package com.scezen.microservices.contrat_mongodb.model;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "gestionprevdb")
@EqualsAndHashCode(of= {"id","numeroContrat"})
@ToString(of= {"id","numeroContrat","dateDebut","numeroAssure","numeroProduit"})
public class Contrat {
	
	@Id
	public String id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date dateDebut;
	
	@NotNull
	@Indexed(unique = true, direction = IndexDirection.DESCENDING)
	public Long numeroContrat;
	
	@NotNull
	public Long numeroAssure;
	
	@NotNull
	public Long numeroProduit;

}
	
