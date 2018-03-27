
package com.homeunion.investor.property.domain.media;

import java.util.List;

public class PropertyMedia {

	private List<PhotoDetail> photos;
	private List<VideoDetail> videos;
	private List<TourDetail> tours;

	public List<PhotoDetail> getPhotos() {

		return photos;
	}

	public void setPhotos(List<PhotoDetail> photos) {

		this.photos = photos;
	}

	public List<VideoDetail> getVideos() {

		return videos;
	}

	public void setVideos(List<VideoDetail> videos) {

		this.videos = videos;
	}

	public List<TourDetail> getTours() {

		return tours;
	}

	public void setTours(List<TourDetail> tours) {

		this.tours = tours;
	}
}
