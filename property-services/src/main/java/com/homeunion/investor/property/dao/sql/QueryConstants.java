
package com.homeunion.investor.property.dao.sql;

public interface QueryConstants {

	String FIN_TYPE_TOKEN = "%FIN_TYPE%";
	String INV_GOAL_TOKEN = "%INV_GOAL%";
	String SORT_COL_TOKEN = "%SORT_COL%";
	String SORT_DIR_TOKEN = "%SORT_DIR%";
	String SORT_YEAR_BUILT = "prop.year_built";
	String SORT_ASKING_PRICE = "perf.asking_price";
	String SORT_INVESTMENT = "perf." + FIN_TYPE_TOKEN + "_investment";
	String SORT_FINANCED_COC_RETURN = "perf.financed_cash_oncash_return";
	String SORT_ALLCASH_COC_RETURN = "perf.allcash_oncash_return";
	String SORT_FINANCED_RETURN = "perf.financed_return";
	String SORT_ALLCASH_RETURN = "perf.allcash_oncash_return";
	String SORT_TOTAL_RETURN = "perf." + FIN_TYPE_TOKEN + "_total_annualized_return";
	String SORT_HU_SELECT = "huselect";
	String SORT_APPRECIATION = "perf.appreciation_rate";
	String ALLCASH_INVESTMENT = "allcash_investment";
	String FINANCED_INVESTMENT = "financed_investment";
	String ASKING_PRICE = "asking_price";
	String ASSET_CLASS_ID = "propertyassetclassid";
	String PROPERTY_SEARCH_FROM_WHERE_CLAUSE = " FROM properties.tblproperty prop"
	                                           + " INNER JOIN properties.tblproperty_performance perf ON (prop.propertyid = perf.tblproperty_propertyid)"
	                                           + " INNER JOIN properties.tbllisting listing ON (listing.tblproperty_propertyid = prop.propertyid AND listing.current_record = 1)"
	                                           + " INNER JOIN properties.tblpropertyassetclass_property_mapping propmapping ON (propmapping.propertyid = prop.propertyid)"
	                                           + " LEFT JOIN properties.tbllistingphotolink tpl ON (tpl.tblproperty_propertyid = prop.propertyid AND tpl.default_image = 1 AND tpl.isdeleted = 0 AND tpl.showon_web = 1)"
	                                           + " LEFT JOIN properties.tblhuselect hus ON (hus.tblproperty_propertyid = prop.propertyid AND hus.ready_for_investors = 1  AND hus.is_deleted = 0)"
	                                           + " WHERE prop.property_status = '31' AND prop.hu_status = 301 AND prop.isdeleted = 0 AND prop.show_onweb = 1"
	                                           + " AND propmapping.propertyassetclassid IN (:assetClassIds)"
	                                           + " AND prop.nir IN (:nir)"
	                                           + " AND perf.asking_price >= :minPrice"
	                                           + " AND "
	                                           + SORT_TOTAL_RETURN
	                                           + " BETWEEN :minTotalReturn AND :maxTotalReturn"
	                                           + " AND perf."
	                                           + FIN_TYPE_TOKEN
	                                           + "_investment <= :investmentAmount";
	String PROPERTY_BASIC_INFO_COLUMNS = " prop.propertyid,"
	                                     + " prop.address,"
	                                     + " prop.unit_number,"
	                                     + " prop.city,"
	                                     + " prop.state,"
	                                     + " prop.zip,"
	                                     + " prop.bed_rooms,"
	                                     + " prop.bath_rooms,"
	                                     + " prop.m_halfBathCount,"
	                                     + " prop.year_built,"
	                                     + " prop.total_sqft,"
	                                     + " prop.property_status,"
	                                     + " prop.hu_status,"
	                                     + " prop.latitude,"
	                                     + " prop.longitude,"
	                                     + " prop.on_homeunion_since_date,"
	                                     + " prop.date_mls_modified,"
	                                     + " prop.num_photos,"
	                                     + " prop.prop_desc, "
	                                     + " prop.property_source, "
	                                     + " prop.property_type_desc, "
	                                     + " prop.HIL,"
	                                     + " prop.nir,"
	                                     + " prop.calculation_freeze_date, "
	                                     + " tpl.thumbnail_link ";
	String PROPERTY_SUMMARY_COLUMNS = PROPERTY_BASIC_INFO_COLUMNS
	                                  + ","
	                                  + " perf.asking_price,"
	                                  + " perf.allcash_investment,"
	                                  + " perf.financed_investment,"
	                                  + " perf.annual_noi,"
	                                  + " perf.financed_annual_cashflow_netof_interest,"
	                                  + " perf.allcash_net_cash_flow_over_investment_period,"
	                                  + " perf.financed_net_cash_flow_over_investment_period,"
	                                  + " perf.annual_net_cashflow,"
	                                  + " perf.allcash_oncash_return,"
	                                  + " perf.financed_cash_oncash_return,"
	                                  + " perf.financed_return,"
	                                  + " perf.allcash_total_annualized_return,"
	                                  + " perf.financed_total_annualized_return,"
	                                  + " perf.projected_appreciation_rate,"
	                                  + " perf.appreciation_rate,"
	                                  + " perf.leased_rent,"
	                                  + " perf.down_payment_percentage,"
	                                  + " perf.rehab_estimate,"
	                                  + " perf.property_management_fee_annual,"
	                                  + " perf.property_taxes_annual,"
	                                  + " perf.property_taxes_monthly,"
	                                  + " perf.property_insurance_annual,"
	                                  + " perf.property_insurance_monthly,"
	                                  + " perf.hoa_fee_annual,"
	                                  + " perf.hoa_fee_monthly,"
	                                  + " perf.annual_leasing_fee,"
	                                  + " listing.mls_name,"
	                                  + " listing.mls_number,"
	                                  + " listing.listing_agentname,"
	                                  + " listing.listing_agentphone,"
	                                  + " listing.assigned_QBR,"
	                                  + " listing.realtor_companyname,"
	                                  + " listing.DOM,"
	                                  + " listing.listing_broker_companyname,"
	                                  + " listing.listing_broker_companyphone,"
	                                  + " propmapping.propertyassetclassid,"
	                                  + " CASE WHEN hus.select_id IS NOT NULL THEN 1 ELSE 0 END AS huselect";
	String QUERY_PROPERTY_SEARCH = "SELECT DISTINCT"
	                               + PROPERTY_SUMMARY_COLUMNS
	                               + PROPERTY_SEARCH_FROM_WHERE_CLAUSE
	                               + " ORDER BY "
	                               + SORT_COL_TOKEN
	                               + " "
	                               + SORT_DIR_TOKEN
	                               + " LIMIT :limitFrom, :limitTo";
	String QUERY_PROPERTY_SEARCH_COUNT = "SELECT COUNT(DISTINCT prop.propertyid)" + PROPERTY_SEARCH_FROM_WHERE_CLAUSE;
	String QUERY_GET_PROPERTY_SUMMARY = "SELECT DISTINCT"
	                                    + PROPERTY_SUMMARY_COLUMNS
	                                    + " FROM properties.tblproperty prop"
	                                    + " INNER JOIN properties.tblproperty_performance perf ON (prop.propertyid = perf.tblproperty_propertyid)"
	                                    + " INNER JOIN properties.tbllisting listing ON (listing.tblproperty_propertyid = :propertyId AND listing.current_record = 1)"
	                                    + " LEFT JOIN properties.tblpropertyassetclass_property_mapping propmapping ON (propmapping.propertyid = prop.propertyid)"
	                                    + " LEFT JOIN properties.tbllistingphotolink tpl ON (tpl.tblproperty_propertyid = prop.propertyid AND tpl.default_image = 1 AND tpl.isdeleted = 0 AND tpl.showon_web = 1)"
	                                    + " LEFT JOIN properties.tblhuselect hus ON (hus.tblproperty_propertyid = prop.propertyid AND hus.ready_for_investors = 1  AND hus.is_deleted = 0)"
	                                    + " WHERE prop.propertyid = :propertyId AND prop.isdeleted = 0 AND prop.show_onweb = 1";
	String QUERY_GET_PROPERTY_LISTING = "SELECT DISTINCT"
	                                    + " l.mls_name,"
	                                    + " l.mls_number,"
	                                    + " l.listing_agentname,"
	                                    + " l.listing_agentphone,"
	                                    + " l.assigned_QBR,"
	                                    + " l.realtor_companyname,"
	                                    + " l.DOM,"
	                                    + " l.listing_broker_companyname,"
	                                    + " l.listing_broker_companyphone"
	                                    + " FROM properties.tbllisting l"
	                                    + " WHERE l.tblproperty_propertyid = :propertyId AND l.current_record = 1";
	String QUERY_GET_PROPERTY_MEDIA = "SELECT DISTINCT"
	                                  + " hus.select_id hus_id,"
	                                  + " photolink.large_link photolink,"
	                                  + " husphoto.media_id hus_photo_id,"
	                                  + " husphoto.is_deleted hus_photo_deleted,"
	                                  + " videolink.video_link videolink,"
	                                  + " husvideo.media_id hus_video_id,"
	                                  + " husvideo.is_deleted hus_video_deleted,"
	                                  + " tourlink.tour_link tourlink,"
	                                  + " hustour.media_id hus_tour_id,"
	                                  + " hustour.is_deleted hus_tour_deleted"
	                                  + " FROM properties.tblproperty prop"
	                                  + " LEFT JOIN properties.tblhuselect hus ON (hus.tblproperty_propertyid = prop.propertyid AND hus.ready_for_investors = 1 AND hus.is_deleted = 0)"
	                                  + " LEFT JOIN properties.tbllistingphotolink photolink ON (photolink.tblproperty_propertyid = prop.propertyid AND photolink.isdeleted = 0 AND photolink.showon_web = 1)"
	                                  + " LEFT JOIN properties.tblhuselectmedia husphoto ON (hus.select_id = husphoto.huselect_link AND photolink.photoid = husphoto.ref_key AND husphoto.type = 'photo')"
	                                  + " LEFT JOIN properties.tbllistingvideolink videolink ON (videolink.tblproperty_propertyid = prop.propertyid AND videolink.isdeleted = 0 AND videolink.show_onweb = 1)"
	                                  + " LEFT JOIN properties.tblhuselectmedia husvideo ON (hus.select_id = husvideo.huselect_link AND videolink.videoid = husvideo.ref_key AND husvideo.type = 'video')"
	                                  + " LEFT JOIN properties.tbllistingtourlink tourlink ON (tourlink.tblproperty_propertyid = prop.propertyid AND tourlink.isdeleted = 0 AND tourlink.show_onweb = 1)"
	                                  + " LEFT JOIN properties.tblhuselectmedia hustour ON (hus.select_id = hustour.huselect_link AND tourlink.tourid = hustour.ref_key AND hustour.type = 'tour')"
	                                  + " WHERE prop.propertyid = :propertyId"
	                                  + " ORDER BY photolink.default_image DESC";
	String QUERY_GET_PROPERTY_COMPS = "SELECT DISTINCT"
	                                  + " tc.mlsname,"
	                                  + " tc.mlsnumber AS active_prop_mlsnumber,"
	                                  + " tc.approved_sold_comps,"
	                                  + " tc.sold_list,"
	                                  + " tc.sold_comp_path,"
	                                  + " tc.comps_price,"
	                                  + " tc.avgCompPricePerSqft,"
	                                  + " tc.approved_leased_comps,"
	                                  + " tc.leased_list,"
	                                  + " tc.leased_comp_path,"
	                                  + " tc.comps_rent,"
	                                  + " tc.avgCompsRentPerSqft,"
	                                  + " tcp.mlsnumber,"
	                                  + " tcp.status AS listingstatus,"
	                                  + " tcp.address,"
	                                  + " tcp.bed,"
	                                  + " tcp.baths,"
	                                  + " tcp.half_bath,"
	                                  + " tcp.sqft,"
	                                  + " tcp.yearBuilt,"
	                                  + " tcp.compLatitude,"
	                                  + " tcp.compLongitude,"
	                                  + " tcp.imgPath,"
	                                  + " tcp.saleprice,"
	                                  + " tcp.salePricePerSqft,"
	                                  + " tcp.soldDate,"
	                                  + " tcp.rent,"
	                                  + " tcp.rentPerSqft,"
	                                  + " tcp.leasedDate"
	                                  + " FROM properties.tblcompdetails tc"
	                                  + " LEFT JOIN properties.tblcompproperties tcp ON (tcp.mlsname = tc.mlsname AND tcp.activeProp = tc.mlsnumber)"
	                                  + " WHERE tc.mlsname = :mlsName AND tc.mlsnumber = :mlsNumber"
	                                  + " AND (tc.approved_sold_comps = 1 OR tc.approved_leased_comps = 1)";
	String QUERY_GET_PROPERTY_SALE_HISTORY = "SELECT "
	                                         + "count(p.property_unit_id) unitCount, "
	                                         + " p.asset_id, "
	                                         + " i.investment_id, "
	                                         + " i.property_id, "
	                                         + " i.investment_amount, "
	                                         + " i.closingEndDate "
	                                         + " FROM embrace.tbl_investment i "
	                                         + " LEFT JOIN embrace.tbl_asset a ON a.investment_id = i.investment_id "
	                                         + " LEFT JOIN embrace.tbl_propertyunit p ON p.investment_id = a.investment_id"
	                                         + " WHERE a.property_id = :propertyId AND i.investment_status = 'Purchased' GROUP BY i.property_id;";
	String QUERY_GET_ASSET_CLASS_PROPERTIES = "SELECT DISTINCT"
	                                          + PROPERTY_SUMMARY_COLUMNS
	                                          + " FROM properties.tblproperty prop"
	                                          + " INNER JOIN properties.tblproperty_performance perf ON (prop.propertyid = perf.tblproperty_propertyid)"
	                                          + " INNER JOIN properties.tbllisting listing ON (listing.tblproperty_propertyid = prop.propertyid AND listing.current_record = 1)"
	                                          + " INNER JOIN properties.tblpropertyassetclass_property_mapping propmapping ON (propmapping.propertyid = prop.propertyid)"
	                                          + " LEFT JOIN properties.tbllistingphotolink tpl ON (tpl.tblproperty_propertyid = prop.propertyid AND tpl.default_image = 1 AND tpl.isdeleted = 0 AND tpl.showon_web = 1)"
	                                          + " LEFT JOIN properties.tblhuselect hus ON (hus.tblproperty_propertyid = prop.propertyid AND hus.ready_for_investors = 1  AND hus.is_deleted = 0)"
	                                          + " WHERE prop.property_status = '31' AND hu_status = 301 AND prop.isdeleted = 0 AND prop.show_onweb = 1"
	                                          + " AND propmapping.propertyassetclassid = :assetClassId";
	String QUERY_GET_EMPLOYERS_INFO = "CALL properties.getemployerwithinmiles(:latitude,:longitude,:radius,'H');";
}
