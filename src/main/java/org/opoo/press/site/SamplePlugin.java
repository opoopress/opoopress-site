package org.opoo.press.site;

import java.util.List;

import org.opoo.press.Plugin;
import org.opoo.press.Post;
import org.opoo.press.Registry;
import org.opoo.press.Site;
import org.opoo.press.filter.SiteFilterAdapter;

public class SamplePlugin implements Plugin{

	@Override
	public void initialize(Registry reg) {
		reg.registerSiteFilter(new MyTestSiteFilter());
	}
	
	static class MyTestSiteFilter extends SiteFilterAdapter{
		@Override
		public int getOrder() {
			return super.getOrder() + 100;
		}

		@Override
		public void postWrite(Site site) {
			super.postWrite(site);
			
			List<Post> posts = site.getPosts();
			System.out.println("-- There are " + posts.size() + " posts in this site. --");
		}
	}
}
