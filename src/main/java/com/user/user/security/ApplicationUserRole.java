// package com.user.user.security;

// import java.util.Set;
// import java.util.stream.Collectors;

// import com.google.common.collect.Sets;


// import org.springframework.security.core.authority.SimpleGrantedAuthority;

// import static com.google.common.collect.Sets.newHashSet;
// import static com.user.user.security.ApplicationUserPermission.*;

// public enum ApplicationUserRole {
//     CANDIDATE(Sets.newHashSet(CANDI_PERM)),
//     RECRUITER(Sets.newHashSet(RECRU_PERM)),
//     PANELIST(Sets.newHashSet(PANEL_PERM)),
//     HR(Sets.newHashSet(HRe_PERM)),
//     SCHEDULER(Sets.newHashSet(SCHED_PERM)),
//     INTERVIEWER(Sets.newHashSet(INTER_PERM)),
//     ADMIN(newHashSet(CANDI_PERM,RECRU_PERM, PANEL_PERM,HRe_PERM, INTER_PERM, SCHED_PERM ));

//     // private final Set<ApplicationUserPermission> permissions;

//     // ApplicationUserRole(Set<ApplicationUserPermission> permissions){
//     //     this.permissions = permissions;
//     // }

//     // public Set<ApplicationUserPermission> getPermissions(){
//     //     return permissions;
//     // }

//     // public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
//     //     Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
//     //     .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//     //     .collect((Collectors.toSet()));
//     //     permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//     //     return permissions;
//     // }

// }
