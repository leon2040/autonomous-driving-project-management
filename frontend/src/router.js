
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProjectManagementProjectManager from "./components/listers/ProjectManagementProjectCards"
import ProjectManagementProjectDetail from "./components/listers/ProjectManagementProjectDetail"

import DevelopmentGuideDeveloperGuideManager from "./components/listers/DevelopmentGuideDeveloperGuideCards"
import DevelopmentGuideDeveloperGuideDetail from "./components/listers/DevelopmentGuideDeveloperGuideDetail"

import EducationSupportEducationManager from "./components/listers/EducationSupportEducationCards"
import EducationSupportEducationDetail from "./components/listers/EducationSupportEducationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/projectManagements/projects',
                name: 'ProjectManagementProjectManager',
                component: ProjectManagementProjectManager
            },
            {
                path: '/projectManagements/projects/:id',
                name: 'ProjectManagementProjectDetail',
                component: ProjectManagementProjectDetail
            },

            {
                path: '/developmentGuides/developerGuides',
                name: 'DevelopmentGuideDeveloperGuideManager',
                component: DevelopmentGuideDeveloperGuideManager
            },
            {
                path: '/developmentGuides/developerGuides/:id',
                name: 'DevelopmentGuideDeveloperGuideDetail',
                component: DevelopmentGuideDeveloperGuideDetail
            },

            {
                path: '/educationSupports/educations',
                name: 'EducationSupportEducationManager',
                component: EducationSupportEducationManager
            },
            {
                path: '/educationSupports/educations/:id',
                name: 'EducationSupportEducationDetail',
                component: EducationSupportEducationDetail
            },



    ]
})
