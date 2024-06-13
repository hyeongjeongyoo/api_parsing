package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * {
  "albumId": 1,
  "id": 5,
  "title": "natus nisi omnis corporis facere molestiae rerum in",
  "url": "https://via.placeholder.com/600/f66b97",
  "thumbnailUrl": "https://via.placeholder.com/150/f66b97"
}
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class photo {
	
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;

}
