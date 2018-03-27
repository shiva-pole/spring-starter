
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.domain.media.PhotoDetail;
import com.homeunion.investor.property.domain.media.PropertyMedia;
import com.homeunion.investor.property.domain.media.TourDetail;
import com.homeunion.investor.property.domain.media.VideoDetail;

@Component
public class PropertyMediaExtractor implements ResultSetExtractor<PropertyMedia> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyMediaExtractor.class);

	@Override
	public PropertyMedia extractData(ResultSet rs) throws SQLException, DataAccessException {

		LOGGER.debug("Mapping result set to PropertyMedia object");
		Map<String, Boolean> photoLinks = new LinkedHashMap<String, Boolean>();
		Map<String, Boolean> videoLinks = new LinkedHashMap<String, Boolean>();
		Map<String, Boolean> tourLinks = new LinkedHashMap<String, Boolean>();
		while (rs.next()) {
			//photos
			String photoLink = rs.getString("photolink");
			String husPhotoId = rs.getString("hus_photo_id");
			int husPhotoDeleted = rs.getInt("hus_photo_deleted");
			//if hu select photo is deleted, then dont show the photo
			if (husPhotoDeleted != 1 && photoLink != null) {
				photoLinks.put(photoLink, husPhotoId != null);
			}
			//videos
			String videoLink = rs.getString("videolink");
			String husVideoId = rs.getString("hus_video_id");
			int husVideoDeleted = rs.getInt("hus_video_deleted");
			//if hu select video is deleted, then dont show the video
			if (husVideoDeleted != 1 && videoLink != null) {
				videoLinks.put(videoLink, husVideoId != null);
			}
			//tours
			String tourLink = rs.getString("tourlink");
			String husTourId = rs.getString("hus_tour_id");
			int husTourDeleted = rs.getInt("hus_tour_deleted");
			//if hu select tour is deleted, then dont show the tour
			if (husTourDeleted != 1 && tourLink != null) {
				tourLinks.put(tourLink, husTourId != null);
			}
		}
		return preparePropertyMedia(photoLinks, videoLinks, tourLinks);
	}

	private PropertyMedia preparePropertyMedia(Map<String, Boolean> photoLinks, Map<String, Boolean> videoLinks, Map<String, Boolean> tourLinks) {

		PropertyMedia propertyMedia = new PropertyMedia();
		//photos
		List<PhotoDetail> photos = new ArrayList<>();
		for (Map.Entry<String, Boolean> entry : photoLinks.entrySet()) {
			PhotoDetail photo = new PhotoDetail();
			photo.setPhotoLink(entry.getKey());
			photo.setHuSelect(entry.getValue());
			photos.add(photo);
		}
		propertyMedia.setPhotos(photos);
		//videos
		List<VideoDetail> videos = new ArrayList<>();
		for (Map.Entry<String, Boolean> entry : videoLinks.entrySet()) {
			VideoDetail video = new VideoDetail();
			video.setVideoLink(entry.getKey());
			video.setHuSelect(entry.getValue());
			videos.add(video);
		}
		propertyMedia.setVideos(videos);
		//tours
		List<TourDetail> tours = new ArrayList<>();
		for (Map.Entry<String, Boolean> entry : tourLinks.entrySet()) {
			TourDetail tour = new TourDetail();
			tour.setTourLink(entry.getKey());
			tour.setHuSelect(entry.getValue());
			tours.add(tour);
		}
		propertyMedia.setTours(tours);
		return propertyMedia;
	}
}
