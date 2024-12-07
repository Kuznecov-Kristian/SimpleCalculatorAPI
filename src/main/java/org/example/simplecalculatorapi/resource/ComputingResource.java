package org.example.simplecalculatorapi.resource;

import org.example.simplecalculatorapi.entity.Issue;
import org.example.simplecalculatorapi.entity.User;
import org.example.simplecalculatorapi.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComputingResource {

    @Autowired
    private IssueService issueService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/solve")
    public Issue processIssue(@RequestBody Issue issue) {
        return issueService.solve(issue);
    }
}
