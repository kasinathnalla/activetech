package com.arkiv.sports.referee.config;//package com.arkiv.sports.com.arkiv.sports.referee.config;
//
//import java.io.Serializable;
//
//import org.ihc.messaging.domain.model.Channel;
//import org.ihc.messaging.domain.model.ChannelUser;
//import org.ihc.messaging.repository.ChannelRepository;
//import org.ihc.messaging.repository.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.PermissionEvaluator;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomPermissionEvaluator implements PermissionEvaluator {
//
//    @Autowired
//    private MessageRepository messageRepository;
//    @Autowired
//    private ChannelRepository channelRepository;
//
//    @Override
//    public boolean hasPermission( Authentication authentication, Object targetDomainObject, Object permission ) {
//        return false;
//    }
//
//    @Override
//    public boolean hasPermission( Authentication authentication, Serializable targetId, String targetType, Object permission ) {
//        if ( "Channel".equals( targetType ) ) {
//            if ( permission != null && "hasChannelUser".equals( permission.toString( ) ) ) {
//                return userIsPartOfChannel( getUsername( authentication ), ( long ) targetId );
//            }
//        }
//        if ( "File".equals( targetType ) ) {
//            if ( permission != null && "wasUploadedBy".equals( permission.toString( ) ) ) {
//                return userUploadedFile( getUsername( authentication ), ( long ) targetId );
//            }
//        }
//        if ( "Message".equals( targetType ) ) {
//            if ( permission != null && "wasCreatedBy".equals( permission.toString( ) ) ) {
//                return userIsPartOfChannel( getUsername( authentication ), ( long ) targetId );
//            }
//        }
//        return false;
//    }
//
//    private boolean userIsPartOfChannel( String username, long channelId ) {
//        Channel channel = channelRepository.findOne( channelId );
//        if ( channel != null ) {
//
//            for ( ChannelUser userChannel : channel.getChannelUsers( ) ) {
//                if ( userChannel.getUser( ) != null ) {
//                    if ( username.equalsIgnoreCase( userChannel.getUser( ).getUsername( ) ) ) {
//                        return true;
//                    }
//                }
//
//            }
//        }
//        return false;
//    }
//
//    private boolean userUploadedFile( String username, long fileId ) {
//
//        return false;
//    }
//
//    private String getUsername( Authentication authentication ) {
//        UserDetails springSecurityUser = null;
//        String userName = null;
//
//        if ( authentication != null ) {
//            if ( authentication.getPrincipal( ) instanceof UserDetails) {
//                springSecurityUser = (UserDetails) authentication.getPrincipal( );
//                userName = springSecurityUser.getUsername( );
//            } else if ( authentication.getPrincipal( ) instanceof String ) {
//                userName = ( String ) authentication.getPrincipal( );
//            }
//        }
//
//        return userName;
//    }
//}
