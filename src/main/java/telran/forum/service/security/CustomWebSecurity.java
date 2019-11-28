package telran.forum.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import telran.forum.dao.ForumRepository;
import telran.forum.dao.UserAccountRepository;
import telran.forum.model.Post;

@Component("customSecurity")
public class CustomWebSecurity {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	ForumRepository forumRepository;
	
	public boolean checkAuthorityForPost(String id, Authentication authentication) {
		Post post = forumRepository.findById(id).orElse(null);
		if (post == null) {
			return false;
		}
//		UserAccount userAccount = 
//				userAccountRepository.findById(authentication.getName()).get();
//		return post.getAuthor().equals(authentication.getName()) 
//				|| userAccount.getRoles().contains("Moderator");
		return post.getAuthor().equals(authentication.getName()) && !authentication.getAuthorities().isEmpty();
	}
}
